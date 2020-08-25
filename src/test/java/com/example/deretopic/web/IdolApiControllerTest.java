package com.example.deretopic.web;

import com.example.deretopic.domain.uwasa.UwasaEntity;
import com.example.deretopic.domain.uwasa.UwasaEntityRepository;
import com.example.deretopic.web.dto.UwasaEntitySaveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IdolApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private UwasaEntityRepository uwasaEntityRepository;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @BeforeEach
    @AfterEach
    public void teardown() {
        uwasaEntityRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void uwasa_enroll() throws Exception {
        // given
        String idolNameJa = "ja";
        Integer topicNum = 1;
        String uwasaJa = "ee";
        String uwasaKo = "kk";

        UwasaEntitySaveDTO dto = UwasaEntitySaveDTO.builder()
                .idolNameJa(idolNameJa)
                .tempHash("asdf")
                .topicNum(topicNum)
                .ttsAudioBase64("")
                .uwasaJa(uwasaJa)
                .uwasaKo(uwasaKo)
                .idolId(1l)
                .build();

        String url = "http://localhost:" + port + "/api/idol/uwasa";

        // when
        mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isTTSInserted").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.uwasaId").isNumber());

        // then
        List<UwasaEntity> list = uwasaEntityRepository.findAll();
        assertThat(list.get(0).getUwasaKo()).isEqualTo(uwasaKo);
    }
}
