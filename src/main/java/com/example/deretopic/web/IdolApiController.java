package com.example.deretopic.web;

import com.example.deretopic.service.IdolEntityService;
import com.example.deretopic.service.UwasaEntityService;
import com.example.deretopic.util.HashUtil;
import com.example.deretopic.web.dto.IdolSimpleResponseDTO;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import com.example.deretopic.web.dto.UwasaEntitySaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
    public List<UwasaEntityDTO> getUwasaByPageRequest(@PathVariable Integer pageNum) {
        PageRequest pageRequest = PageRequest.of(pageNum, 30);
        return uwasaEntityService.findByPageRequest(pageRequest);
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
            return result;
        }

        String ttsAudioBase64 = uwasa.getTtsAudioBase64();

        Long insertResult = uwasaEntityService.save(uwasa);
        result.put("uwasaId", insertResult);

        if(ttsAudioBase64 == null || ttsAudioBase64.equals("")) {
            result.put("isTTSInserted", false);
            return result;
        }

        // 파일 이름 규칙
        // voice_{id}_{nameJa}_{topicNum}.mp3

        try {
            String ttsFileName = "voice_" + insertResult + "_"
                    + uwasa.getIdolNameJa() + "_" + uwasa.getTopicNum() + ".mp3";
            File ttsFile = new File(FileSystemView.getFileSystemView().getHomeDirectory()
                    + "/deretopic/resources/tts/" + ttsFileName);

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodedBytes = decoder.decode(ttsAudioBase64.getBytes());
            FileOutputStream fileOutputStream = new FileOutputStream(ttsFile);
            fileOutputStream.write(decodedBytes);
            fileOutputStream.close();
            result.put("isTTSInserted", true);
        } catch(IOException e) {
            System.err.println(e);
            result.put("isTTSInserted", false);
        }

        return result;
    }
}
