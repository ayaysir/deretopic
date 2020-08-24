package com.example.deretopic.web.dto;

import com.example.deretopic.domain.uwasa.UwasaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UwasaEntityDTO {

    private Long id;
    private String idolNameJa, uwasaJa, uwasaKo;
    private Integer topicNum;

    // 주석
    private String comment;
    // tts 파일 이름
    private String ttsFileName;

    public UwasaEntityDTO(UwasaEntity uwasaEntity) {
        this.id = uwasaEntity.getId();
        this.idolNameJa = uwasaEntity.getIdolNameJa();
        this.topicNum = uwasaEntity.getTopicNum();
        this.uwasaJa = uwasaEntity.getUwasaJa();
        this.uwasaKo = uwasaEntity.getUwasaKo();
        this.comment = uwasaEntity.getComment();
        this.ttsFileName = uwasaEntity.getTtsFileName();
    }
}
