package com.example.deretopic.domain.idol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdolEntityRepository extends JpaRepository<IdolEntity, Long> {

    List<IdolEntity> findByName(String nameJa);
}
