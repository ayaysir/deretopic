package com.example.deretopic.domain.uwasa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UwasaEntityRepository extends JpaRepository<UwasaEntity, Long> {

    // 내용으로 검색
    List<UwasaEntity> findByUwasaJaContainingOrUwasaKoContaining(String keywordJa, String keywordKo,
                                                                 Pageable pageable);

    // name_ja 로 검색
    List<UwasaEntity> findByIdolNameJa(String idolName);
}
