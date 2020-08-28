package com.example.deretopic.web;

import com.example.deretopic.domain.common.BloodType;
import com.example.deretopic.domain.common.Constellation;
import com.example.deretopic.domain.common.Handedness;
import com.example.deretopic.domain.common.IdolType;
import com.example.deretopic.service.IdolEntityService;
import com.example.deretopic.util.FileIOUtil;
import com.example.deretopic.web.dto.IdolRequestDTO;
import com.example.deretopic.web.dto.IdolResponseDTO;
import com.example.deretopic.web.dto.IdolSimpleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class IdolApiController {

    private final IdolEntityService idolEntityService;

    // api / idol / {작업} / {이름}

//    @GetMapping("/api/idol/redirect/test")
//    public String inputOne() {
//        idolEntityService.save("computer", "시마무라 우즈키");
//        return "do test /api/idol/redirect/{nameJa}";
//    }

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

    @GetMapping("/api/idol/simple")
    public List<IdolSimpleResponseDTO> getIdolSimpleList() {
        return idolEntityService.findAllSimple();
    }

    @GetMapping("/api/idol/profile/{id}")
    public IdolResponseDTO getIdolById(@PathVariable Long id) {
        return idolEntityService.findById(id);
    }

    @PutMapping("/api/idol/profile/{id}")
    public Map<String, Object> putIdol(@PathVariable Long id, @RequestBody IdolRequestDTO dto) throws IOException {
        System.out.println(dto.getPuchiBase64());
        Map<String, Object> result = new HashMap<>();

        System.out.println(">>>> baset64:" + dto.getPuchiBase64());
        System.out.println(dto);
        System.out.println(dto.getPuchiBase64().equals(""));

        if(!dto.getPuchiBase64().equals("")) {
            String relPath = "resources/profile_puchi_normal";
            FileIOUtil.writeFileToResourceFromBASE64Bytes(relPath, id + ".png", dto.getPuchiBase64().getBytes());
        }

        Long resultId = idolEntityService.update(dto);
        if(resultId.equals(id)) {
            result.put("result", "OK");
        } else {
            result.put("result", "error");
        }

        result.put("id", id);
        result.put("status", 200);

        return result;
    }

    @GetMapping("/api/idol/puchi/{id}")
    public ResponseEntity<Resource> getPuchi(@PathVariable Long id, HttpServletRequest request) throws Exception {
        return FileIOUtil.flushFileFromResources("resources/profile_puchi_normal",
                id + ".png", request);
    }

    @GetMapping("/api/idol/insert-info")
    public Map<String, Object> getInsertEnumInfo() {
        Map<String, Object> result = new HashMap<>();

        result.put("BloodType", BloodType.values());
        result.put("Constellation", Constellation.values());
        result.put("Handedness", Handedness.values());
        result.put("IdolType", IdolType.values());

        return result;
    }

    public static void main(String[] args) {


    }


}


