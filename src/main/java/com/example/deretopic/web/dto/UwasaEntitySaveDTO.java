package com.example.deretopic.web.dto;

import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.uwasa.UwasaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UwasaEntitySaveDTO {
    private String idolNameJa, uwasaJa, uwasaKo;
    private String ttsAudioBase64, tempHash;
    private Integer topicNum;

    // 주석
    private String comment;

    private Long idolId;

    @Setter
    private IdolEntity idol;

    @Builder
    public UwasaEntitySaveDTO(String idolNameJa, String uwasaJa, String uwasaKo,
                              Integer topicNum,
                              String comment,
                              String ttsAudioBase64, String tempHash, Long idolId
                              ) {
        this.idolNameJa = idolNameJa;
        this.uwasaJa = uwasaJa;
        this.uwasaKo = uwasaKo;
        this.topicNum = topicNum;
        this.ttsAudioBase64 = ttsAudioBase64;
        this.tempHash = tempHash;
        this.idolId = idolId;
    }

    public UwasaEntity toEntity() {
        return UwasaEntity.builder()
                .idolNameJa(idolNameJa)
                .topicNum(topicNum)
                .uwasaJa(uwasaJa)
                .uwasaKo(uwasaKo)
                .idol(idol)
                .build();
    }
}
