package com.example.deretopic.domain.uwasa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UwasaEntityRepository extends JpaRepository<UwasaEntity, Long> {

    // 내용으로 검색
    List<UwasaEntity> findByUwasaJaContainingOrUwasaKoContaining(String keywordJa, String keywordKo,
                                                                 Pageable pageable);

    // name_ja 로 검색
    List<UwasaEntity> findByIdolNameJa(String idolName);

    // 아이돌 이름으로 검색
    @Query("Select u from UwasaEntity u left join u.idol i  " +
            "where i.name like %:keyword% or i.nameKo like %:keyword% " +
            "or i.nameEn like %:keyword%")
    List<UwasaEntity> findByIdolKeyword(@Param("keyword") String keyword, Pageable pageable);

    // 전체 목록 내림차순
    List<UwasaEntity> findAllByOrderByIdDesc(Pageable pageable);
}
