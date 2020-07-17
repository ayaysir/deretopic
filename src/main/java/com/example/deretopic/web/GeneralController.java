package com.example.deretopic.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }
}
