package com.example.deretopic.web;

import com.example.deretopic.service.IdolEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@RequiredArgsConstructor
@RestController
public class IdolApiController {

    private final IdolEntityService idolEntityService;

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
}
