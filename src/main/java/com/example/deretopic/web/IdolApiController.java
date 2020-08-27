package com.example.deretopic.web;

import com.example.deretopic.service.IdolEntityService;
import com.example.deretopic.service.UwasaEntityService;
import com.example.deretopic.util.FileIOUtil;
import com.example.deretopic.util.HashUtil;
import com.example.deretopic.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class IdolApiController {

    private final IdolEntityService idolEntityService;
    private final UwasaEntityService uwasaEntityService;

    // api / idol / {작업} / {이름}

    @GetMapping("/api/idol/redirect/test")
    public String inputOne() {
        idolEntityService.save("computer", "시마무라 우즈키");
        return "do test /api/idol/redirect/{nameJa}";
    }

    @GetMapping("/api/idol/redirect/{nameJa}")
    public void redirectWikiByNameJa(HttpServletResponse response, @PathVariable String nameJa) throws IOException {

        String nameKo = null;
        try {
            nameKo = idolEntityService.findNameKoByNameJa(nameJa);
        } catch(IndexOutOfBoundsException e) {
            System.err.println(e);
        }
        if(nameKo != null) {
            response.sendRedirect("http://namu.wiki/w/"
                    + URLEncoder.encode(nameKo, "UTF-8").replace("+", "%20"));
        } else {
            response.sendRedirect("http://namu.wiki/w/"
                    + URLEncoder.encode("아이돌마스터 신데렐라 걸즈/등장인물", "UTF-8").replace("+", "%20"));
        }
    }

    @GetMapping("/api/idol/uwasa")
    public List<UwasaEntityDTO> getAllUwasa() {
        return uwasaEntityService.findAll();
    }

    @GetMapping("/api/idol/uwasa/pages/{pageNum}")
    public List<UwasaEntityDTO> getUwasaByPageRequest(@PathVariable Integer pageNum,
                                                      @RequestParam(value = "uwasaKeyword", required = false)
                                                              String uwasaKeyword,
                                                      @RequestParam(value = "idolKeyword", required = false)
                                                                  String idolKeyword,
                                                      @RequestParam(value = "reverseAll", required = false) boolean reverseAll) {
        PageRequest pageRequest = PageRequest.of(pageNum, 30);

        if(uwasaKeyword != null) {
            return uwasaEntityService.findUwasaByKeyword(uwasaKeyword, pageRequest);
        } else if(idolKeyword != null) {
            return uwasaEntityService.findByIdolKeyword(idolKeyword, pageRequest);
        } else if(reverseAll){
            return uwasaEntityService.findByPageRequestReverse(pageRequest);
        } else {
            return uwasaEntityService.findByPageRequest(pageRequest);
        }

    }

    @GetMapping("/api/idol/uwasa/{notPages}")
    public String notPages() {
        return "not pages";
    }

    @GetMapping("/api/idol/simple")
    public List<IdolSimpleResponseDTO> getIdolSimpleList() {
        return idolEntityService.findAllSimple();
    }

    @PostMapping("/api/idol/uwasa")
    public Map<String, Object> addUwasa(@RequestBody UwasaEntitySaveDTO uwasa) throws NoSuchAlgorithmException {
        String tempHash = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b";
        String receivedHash = HashUtil.sha256(uwasa.getTempHash());

        Map<String, Object> result = new HashMap<>();

        if(!tempHash.equals(receivedHash)) {
            result.put("uwasaId", -9999);
            result.put("uploadStatus", "PasswordIsWrong");
            return result;
        }

        String ttsAudioBase64 = uwasa.getTtsAudioBase64();

        Long insertResult = uwasaEntityService.save(uwasa);
        result.put("uwasaId", insertResult);

        if(ttsAudioBase64 == null || ttsAudioBase64.equals("")) {
            result.put("isTTSInserted", false);
            result.put("uploadStatus", "FileIsNull");
            return result;
        } else if(ttsAudioBase64.length() > 400000) {
            result.put("isTTSInserted", false);
            result.put("uploadStatus", "FileIsTooBig");
            return result;
        }

        // 파일 이름 규칙
        // voice_{id}_{nameJa}_{topicNum}.mp3

        try {
            String ttsFileName = "voice_" + insertResult + "_"
                    + uwasa.getIdol().getName() + "_" + uwasa.getTopicNum() + ".mp3";
            String relPath = "resources/tts";

            FileIOUtil.writeFileToResourceFromBASE64Bytes(relPath, ttsFileName, ttsAudioBase64.getBytes());

            result.put("isTTSInserted", true);
            result.put("uploadStatus", "AllSuccess");
            uwasaEntityService.updateTTSOnly(insertResult, ttsFileName);

        } catch(IOException e) {
            System.err.println(e);
            result.put("uploadStatus", "DataInsertedButFileIsNotUploaded");
            result.put("isTTSInserted", false);
        }

        return result;
    }

    @GetMapping("/api/idol/tts/{id}")
    @ResponseStatus(HttpStatus.OK)    // Thymeleaf 사용시 이것을 사용해야 에러가 발생하지 않음
    public ResponseEntity<Resource> getTTS(HttpServletRequest request,
                                           @PathVariable Long id) throws Exception {
        String relPath = "resources/tts";

        UwasaEntityDTO dto = uwasaEntityService.findById(id);

        if (dto.getTtsFileName() != null) {
            return FileIOUtil.flushFileFromResources(relPath, dto.getTtsFileName(), request);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/api/idol/profile/{id}")
    public IdolResponseDTO getIdolById(@PathVariable Long id) {
        return idolEntityService.findById(id);
    }

    @PutMapping("/api/idol/profile/{id}")
    public Map<String, Object> putIdolOnlyPuchi(@PathVariable Long id, @RequestBody IdolRequestDTO dto) throws IOException {
        System.out.println(dto.getPuchiBase64());
        Map<String, Object> result = new HashMap<>();

        String relPath = "resources/profile_puchi_normal";
        FileIOUtil.writeFileToResourceFromBASE64Bytes(relPath, id + ".png", dto.getPuchiBase64().getBytes());

        result.put("id", id);
        result.put("result", "OK");

        return result;
    }
}
