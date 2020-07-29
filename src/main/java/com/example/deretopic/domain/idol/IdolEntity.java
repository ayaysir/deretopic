package com.example.deretopic.domain.idol;

import com.example.deretopic.domain.common.BloodType;
import com.example.deretopic.domain.common.Constellation;
import com.example.deretopic.domain.common.IdolType;
import com.example.deretopic.domain.common.ThreeSize;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor  // 파라미터가 없는 생성자를 만든다.
@Entity
public class IdolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nameEn;
    private String nameKo;

    private Integer age;

    private LocalDate birthday;

    private String birthPlace;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private Integer height;

    private Integer weight;

    // Custom VO를 컬럼에 넣으려면 @Embedded를 사용
    @Embedded
    private ThreeSize threeSize;

    @Enumerated(EnumType.STRING)
    private Constellation constellation;

    @Column
//    @ElementCollection(targetClass = String.class)
//    private List<String> hobby;
    private String hobby;

    @Enumerated(EnumType.STRING)
    private IdolType idolType;

    @Column(columnDefinition = "TEXT")
    private String note;

    // 위키 링크
    private String refKeyword;




    @Builder
    public IdolEntity(Long id, String name, String nameEn, String nameKo,
                      Integer age, LocalDate birthday,
                      String birthPlace, BloodType bloodType, Integer height,
                      Integer weight, ThreeSize threeSize,
                      Constellation constellation, String hobby, IdolType idolType,
                      String note, String refKeyword) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.nameEn = nameEn;
        this.nameKo = nameKo;
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
    }
}
