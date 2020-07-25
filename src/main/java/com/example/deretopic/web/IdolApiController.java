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
        idolEntityService.save("computer", "컴퓨터");
        return "do test /api/idol/redirect/{nameJa}";
    }

    @GetMapping("/api/idol/redirect/{nameJa}")
    public void redirectWikiByNameJa(HttpServletResponse response, @PathVariable String nameJa) throws IOException {
        response.sendRedirect("http://namu.wiki/w/" + URLEncoder.encode(idolEntityService.findNameKoByNameJa(nameJa), "UTF-8"));
    }
}
