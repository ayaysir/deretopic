package com.example.deretopic.domain.idol;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdolEntityRepository extends JpaRepository<IdolEntity, Long> {

    List<IdolEntity> findByName(String nameJa);
}
