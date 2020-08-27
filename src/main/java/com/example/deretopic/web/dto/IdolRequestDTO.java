package com.example.deretopic.web.dto;

import com.example.deretopic.domain.common.BloodType;
import com.example.deretopic.domain.common.Constellation;
import com.example.deretopic.domain.common.IdolType;
import com.example.deretopic.domain.common.ThreeSize;
import com.example.deretopic.domain.idol.IdolEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IdolRequestDTO {
    private Long id;

    private String name;
    private String nameEn;
    private String nameKo;

    private Integer age;

    private LocalDate birthday;

    private String birthPlace;

    private BloodType bloodType;

    private Integer height;

    private Integer weight;

    private ThreeSize threeSize;

    private Constellation constellation;

    private String hobby;

    private IdolType idolType;

    private String note;

    private String refKeyword;

    private String puchiBase64;

    public IdolRequestDTO(IdolEntity idolEntity) {
        this.id = idolEntity.getId();
        this.name = idolEntity.getName();
        this.nameEn = idolEntity.getNameEn();
        this.nameKo = idolEntity.getNameKo();
        this.age = idolEntity.getAge();
        this.birthday = idolEntity.getBirthday();
        this.birthPlace = idolEntity.getBirthPlace();
        this.bloodType = idolEntity.getBloodType();
        this.height = idolEntity.getHeight();
        this.weight = idolEntity.getWeight();
        this.threeSize = idolEntity.getThreeSize();
        this.constellation = idolEntity.getConstellation();
        this.hobby = idolEntity.getHobby();
        this.idolType = idolEntity.getIdolType();
        this.note = idolEntity.getNote();
        this.refKeyword = idolEntity.getRefKeyword();
    }

    @Builder
    public IdolRequestDTO(Long id, String name, String nameEn, String nameKo,
                          Integer age, LocalDate birthday, String birthPlace,
                          BloodType bloodType, Integer height, Integer weight,
                          ThreeSize threeSize, Constellation constellation, String hobby,
                          IdolType idolType, String note, String refKeyword,
                          String puchiBase64) {
        this.id = id;
        this.name = name;
        this.nameEn = nameEn;
        this.nameKo = nameKo;
        this.age = age;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.bloodType = bloodType;
        this.height = height;
        this.weight = weight;
        this.threeSize = threeSize;
        this.constellation = constellation;
        this.hobby = hobby;
        this.idolType = idolType;
        this.note = note;
        this.refKeyword = refKeyword;
        this.puchiBase64 = puchiBase64;
    }

}
