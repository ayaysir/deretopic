package com.example.deretopic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpaRouteController {

    @RequestMapping(value = "/v" + "/{path:[^\\.]*}")
    public String redirect(HttpServletRequest request) {
        System.out.println("Request URI: " + request.getRequestURI());
        return "forward:/";
    }

}
