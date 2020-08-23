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
public class IdolSimpleResponseDTO {
    private Long id;

    private String name;
    private String nameEn;
    private String nameKo;


    public IdolSimpleResponseDTO(IdolEntity idolEntity) {
        this.id = idolEntity.getId();
        this.name = idolEntity.getName();
        this.nameEn = idolEntity.getNameEn();
        this.nameKo = idolEntity.getNameKo();
    }

    @Builder
    public IdolSimpleResponseDTO(Long id, String name, String nameEn, String nameKo) {
        this.id = id;
        this.name = name;
        this.nameEn = nameEn;
        this.nameKo = nameKo;
    }
}
