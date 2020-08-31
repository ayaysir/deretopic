package com.example.deretopic.domain.thread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadEntityRepository extends JpaRepository<ThreadEntity, Long> {
    List<ThreadEntity> findByThreadNameOrderByIdDesc(String threadName);
}
