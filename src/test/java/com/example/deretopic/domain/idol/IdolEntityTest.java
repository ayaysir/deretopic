package com.example.deretopic.domain.idol;

import com.example.deretopic.domain.common.*;
import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
import com.example.deretopic.domain.uwasa.UwasaEntity;
import com.example.deretopic.domain.uwasa.UwasaEntityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IdolEntityTest {

    @Autowired
    IdolEntityRepository idolEntityRepository;

    @Autowired
    UwasaEntityRepository uwasaEntityRepository;

    @BeforeEach
    @AfterEach
    public void cleanup() {
        uwasaEntityRepository.deleteAll();
        idolEntityRepository.deleteAll();
    }

    @Test
    public void load_idol() {
        /**
         *   "アナスタシア": {
         *     "age": 15,
         *     "birthday": {
         *       "day": 19,
         *       "month": 9
         *     },
         *     "birthplace": "北海道",
         *     "blood_type": "O",
         *     "bust": 80,
         *     "constellation": "乙女座",
         *     "handedness": "両",
         *     "height": 165,
         *     "hip": 80,
         *     "hobby": [
         *       "ホームパーティ",
         *       "天体観測"
         *     ],
         *     "type": "cool",
         *     "waist": 54,
         *     "weight": 43
         *   },
         */
        // given
        idolEntityRepository.deleteAll();

        String name = "アナスタシア";
        Integer age = 15;
        LocalDate birthday = LocalDate.of(0, 9, 19);
        String birthPlace = "北海道";
        BloodType bloodType = BloodType.O;
        Integer height = 165;
        Integer weight = 43;
        ThreeSize threeSize = ThreeSize.builder().bust(80).waist(54).hip(80).build();
        Constellation constellation = Constellation.VIRGO;
        String hobby = "ホームパーティ,天体観測";
        IdolType idolType = IdolType.COOL;

        Handedness handedness = Handedness.BOTH;
        String imageColor = "#A8C0E6";
        String nameFurigana = "アナスタシア";
        String voiceActorKo = "우에사카 스미레";


        IdolEntity idolEntity = IdolEntity.builder()
                .name(name)
                .age(age)
                .birthday(birthday)
                .birthPlace(birthPlace)
                .bloodType(bloodType)
                .height(height)
                .weight(weight)
                .threeSize(threeSize)
                .constellation(constellation)
                .hobby(hobby)
                .idolType(idolType)
                .handedness(handedness)
                .imageColor(imageColor)
                .nameFurigana(nameFurigana)
                .voiceActorKo(voiceActorKo)
                .build();

        idolEntityRepository.save(idolEntity);

        // when
        List<IdolEntity> idolEntities = idolEntityRepository.findAll();

        // then
        IdolEntity foundIdolEntity = idolEntities.get(0);

        assertThat(foundIdolEntity.getName()).isEqualTo(name);
        assertThat(foundIdolEntity.getBloodType()).isEqualTo(BloodType.O);
        assertThat(foundIdolEntity.getConstellation()).isEqualTo(Constellation.VIRGO);
        assertThat(foundIdolEntity.getThreeSize().getBust()).isEqualTo(80);

        assertThat(foundIdolEntity.getCreatedDate())
                .isAfter(LocalDateTime.of(2020,8,28,0,0,0));

        System.out.println(foundIdolEntity);

    }

}
