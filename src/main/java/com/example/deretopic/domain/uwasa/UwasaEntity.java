package com.example.deretopic.domain.uwasa;

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

    @Builder
    public UwasaEntity(String idolNameJa, Integer topicNum, String uwasaJa, String uwasaKo) {
        this.idolNameJa = idolNameJa;
        this.topicNum = topicNum;
        this.uwasaJa = uwasaJa;
        this.uwasaKo = uwasaKo;
    }
}
