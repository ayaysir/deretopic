package com.example.deretopic.web.dto;

import com.example.deretopic.domain.uwasa.UwasaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UwasaEntitySaveDTO {
    private String idolNameJa, uwasaJa, uwasaKo;
    private String ttsAudioBase64, tempHash;
    private Integer topicNum;

    @Builder
    public UwasaEntitySaveDTO(String idolNameJa, String uwasaJa, String uwasaKo,
                              Integer topicNum,
                              String ttsAudioBase64, String tempHash) {
        this.idolNameJa = idolNameJa;
        this.uwasaJa = uwasaJa;
        this.uwasaKo = uwasaKo;
        this.topicNum = topicNum;
        this.ttsAudioBase64 = ttsAudioBase64;
        this.tempHash = tempHash;
    }

    public UwasaEntity toEntity() {
        return UwasaEntity.builder()
                .idolNameJa(idolNameJa)
                .topicNum(topicNum)
                .uwasaJa(uwasaJa)
                .uwasaKo(uwasaKo)
                .build();
    }
}
