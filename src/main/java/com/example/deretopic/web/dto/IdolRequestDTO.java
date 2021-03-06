package com.example.deretopic.web.dto;

import com.example.deretopic.domain.common.*;
import com.example.deretopic.domain.idol.IdolEntity;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    // DTO 전용
    private String puchiBase64;
    private String iconBase64;

    // 2020-08-28
    private String nameFurigana;
    private String imageColor;
    private String voiceActorKo;

    @Enumerated(EnumType.STRING)
    private Handedness handedness;

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

        // 2020-08-28
        this.nameFurigana = nameFurigana;
        this.imageColor = imageColor;
        this.voiceActorKo = voiceActorKo;

        this.handedness = handedness;
    }

    @Builder
    public IdolRequestDTO(Long id,
                          String name, String nameEn, String nameKo,
                          Integer age, LocalDate birthday, String birthPlace,
                          BloodType bloodType, Integer height, Integer weight,
                          ThreeSize threeSize, Constellation constellation,
                          String hobby, IdolType idolType, String note, String refKeyword,
                          String puchiBase64, String iconBase64,
                          String nameFurigana, String imageColor,
                          String voiceActorKo, Handedness handedness) {
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
        this.iconBase64 = iconBase64;
        this.nameFurigana = nameFurigana;
        this.imageColor = imageColor;
        this.voiceActorKo = voiceActorKo;
        this.handedness = handedness;
    }

    public IdolEntity toEntity() {
        return IdolEntity.builder()
                .id(this.id)
                .voiceActorKo(voiceActorKo)
                .nameFurigana(nameFurigana)
                .imageColor(imageColor)
                .threeSize(threeSize)
                .age(age)
                .birthday(birthday)
                .birthPlace(birthPlace)
                .bloodType(bloodType)
                .constellation(constellation)
                .handedness(handedness)
                .height(height)
                .hobby(hobby)
                .idolType(idolType)
                .name(name)
                .nameEn(nameEn)
                .nameKo(nameKo)
                .note(note)
                .refKeyword(refKeyword)
                .weight(weight)
                .build();
    }

}
