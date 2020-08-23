package com.example.deretopic.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GeneralController.class)
public class GeneralControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void return_test() throws Exception {
        String test = "데레스테 소문";

        mvc.perform(get("/api/test/title"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));
    }



}
