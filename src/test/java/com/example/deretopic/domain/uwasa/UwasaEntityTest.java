package com.example.deretopic.domain.uwasa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UwasaEntityTest {

    @Autowired
    UwasaEntityRepository uwasaEntityRepository;

    @BeforeEach
    @AfterEach
    public void cleanup() {
        uwasaEntityRepository.deleteAll();
    }

    @Test
    public void insert_uwasa() {
        String idolNameJa = "ja";
        Integer topicNum = 1;
        String uwasaJa = "ee";
        String uwasaKo = "kk";

        // given
        uwasaEntityRepository.save(UwasaEntity.builder()
                .idolNameJa(idolNameJa)
                .topicNum(topicNum)
                .uwasaJa(uwasaJa)
                .uwasaKo(uwasaKo)
                .build());

        // when
        List<UwasaEntity> list = uwasaEntityRepository.findAll();

        // then
        UwasaEntity entity = (UwasaEntity) list.get(0);

        assertThat(entity.getId()).isNotZero();
        assertThat(entity.getUwasaJa()).isEqualTo(uwasaJa);
        assertThat(entity.getTopicNum()).isEqualTo(topicNum);
    }
}
