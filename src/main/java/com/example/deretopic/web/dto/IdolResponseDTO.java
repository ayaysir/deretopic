package com.example.deretopic.web.dto;

import com.example.deretopic.domain.common.*;
import com.example.deretopic.domain.idol.IdolEntity;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IdolResponseDTO {
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

    // date
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    // 2020-08-28
    private String nameFurigana;
    private String imageColor;
    private String voiceActorKo;

    private Handedness handedness;


    public IdolResponseDTO(IdolEntity idolEntity) {
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

        this.createdDate = idolEntity.getCreatedDate();
        this.createdDate = idolEntity.getModifiedDate();

        this.nameFurigana = idolEntity.getNameFurigana();
        this.imageColor = idolEntity.getImageColor();
        this.voiceActorKo = idolEntity.getVoiceActorKo();

        this.handedness = idolEntity.getHandedness();

    }


}
