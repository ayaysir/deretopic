package com.example.deretopic.domain.uwasa;

import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UwasaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 실질적 키
    private String idolNameJa;

    private Integer topicNum;

    @Column(columnDefinition = "TEXT")
    private String uwasaJa;

    @Column(columnDefinition = "TEXT")
    private String uwasaKo;

    // 주석
    @Column(columnDefinition = "TEXT")
    private String comment;

    // TTS 파일 이름
    private String ttsFileName;

    // 아이돌 정보 ManyToOne
    @ManyToOne
    @JoinColumn(name = "idol_entity_id")
    private IdolEntity idol;

    @Builder
    public UwasaEntity(String idolNameJa, Integer topicNum,
                       String uwasaJa, String uwasaKo,
                       String comment, String ttsFileName,
                       IdolEntity idol
                       ) {
        this.idolNameJa = idolNameJa;
        this.topicNum = topicNum;
        this.uwasaJa = uwasaJa;
        this.uwasaKo = uwasaKo;
        this.comment = comment;
        this.ttsFileName = ttsFileName;
        this.idol = idol;
    }

    public void updateOnlyTTS(String ttsFileName) {
        this.ttsFileName = ttsFileName;
    }

    public void update(UwasaEntityDTO dto) {
        this.idolNameJa = dto.getIdolNameJa();
        this.topicNum = dto.getTopicNum();
        this.uwasaJa = dto.getUwasaJa();
        this.uwasaKo = dto.getUwasaKo();
        this.comment = dto.getComment();
        this.ttsFileName = dto.getTtsFileName();
    }
}
