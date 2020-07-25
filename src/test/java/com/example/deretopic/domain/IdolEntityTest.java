package com.example.deretopic.domain;

import com.example.deretopic.domain.common.BloodType;
import com.example.deretopic.domain.common.Constellation;
import com.example.deretopic.domain.common.IdolType;
import com.example.deretopic.domain.common.ThreeSize;
import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IdolEntityTest {

    @Autowired
    IdolEntityRepository idolEntityRepository;

    @AfterEach
    public void cleanup() {
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
        String name = "アナスタシア";
        Integer age = 15;
        LocalDate birthday = LocalDate.of(0, 9, 19);
        String birthPlace = "北海道";
        BloodType bloodType = BloodType.O;
        Integer height = 165;
        Integer weight = 43;
        ThreeSize threeSize = ThreeSize.builder().bust(80).waist(54).hip(80).build();
        Constellation constellation = Constellation.VIRGO;
//        List<String> hobby = Arrays.asList("ホームパーティ", "天体観測");
        String hobby = "ホームパーティ,天体観測";
        IdolType idolType = IdolType.COOL;
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


    }

}
