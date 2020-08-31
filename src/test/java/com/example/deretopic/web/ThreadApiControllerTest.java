package com.example.deretopic.web;

import com.example.deretopic.domain.common.BloodType;
import com.example.deretopic.domain.common.Constellation;
import com.example.deretopic.domain.common.IdolType;
import com.example.deretopic.domain.common.ThreeSize;
import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
import com.example.deretopic.domain.thread.ThreadEntity;
import com.example.deretopic.domain.thread.ThreadEntityRepository;
import com.example.deretopic.domain.user.User;
import com.example.deretopic.domain.user.UserRepository;
import com.example.deretopic.domain.uwasa.UwasaEntity;
import com.example.deretopic.domain.uwasa.UwasaEntityRepository;
import com.example.deretopic.payload.LoginRequest;
import com.example.deretopic.payload.SignUpRequest;
import com.example.deretopic.security.oauth.AuthProvider;
import com.example.deretopic.service.ThreadEntityService;
import com.example.deretopic.web.dto.ThreadEntityDTO;
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

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThreadApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ThreadEntityRepository threadEntityRepository;

    @Autowired
    private UserRepository userRepository;


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
        threadEntityRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void signup_and_login_and_insert_thread() throws Exception {
        // given

        String url = "http://localhost:" + port + "/api/thread/";
        String loginUrl = "http://localhost:" + port + "/auth/login/";
        String signupUrl = "http://localhost:" + port + "/auth/signup/";

        String name = "Ee";
        String email = "aa@a.com";
        String password = "1234";

        /*
        .authorId(authorId)
                .category(category)
                .content(content)
                .threadName(threadName)
         */
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setName(name);
        signUpRequest.setEmail(email);
        signUpRequest.setPassword(password);

        LoginRequest loginRequest =  new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        String threadName = "qna";
        ThreadEntityDTO dto = ThreadEntityDTO.builder()
                .authorId(1l)
                .category("e")
                .content("ee")
                .threadName(threadName)
                .build();

        // when
        mvc.perform(MockMvcRequestBuilders.post(signupUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(signUpRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        mvc.perform(MockMvcRequestBuilders.post(loginUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());


        mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // then
        List<ThreadEntity> list = threadEntityRepository.findByThreadNameOrderByIdDesc("qna");
        assertThat(list.get(0).getThreadName()).isEqualTo(threadName);

        System.out.println(list.get(0));
    }
}
