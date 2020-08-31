package com.example.deretopic.service;

import com.example.deretopic.domain.thread.ThreadEntity;
import com.example.deretopic.domain.thread.ThreadEntityRepository;
import com.example.deretopic.domain.user.UserRepository;
import com.example.deretopic.web.dto.ThreadEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ThreadEntityService {

    private final ThreadEntityRepository threadEntityRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(ThreadEntityDTO dto) {
        ThreadEntity entity = dto.toEntity();
        entity.setAuthor(userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new IllegalStateException("유저가 없습니다. : " + dto.getAuthorId()) ));
        return threadEntityRepository.save(entity).getId();
    }

    @Transactional
    public Long update(ThreadEntityDTO dto) {
        ThreadEntity entity = threadEntityRepository
                .findById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("해당 게시물이 없습니다 id: " + dto.getId()) );
        entity.update(dto);
        return entity.getId();
    }

    @Transactional
    public void delete(Long id) {
        ThreadEntity entity = threadEntityRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("해당 게시물이 없습니다 id: " + id) );
        threadEntityRepository.delete(entity);

    }

    @Transactional(readOnly = true)
    public List<ThreadEntityDTO> findByThreadNameOrderByDesc(String threadName) {
        return threadEntityRepository.findByThreadNameOrderByIdDesc(threadName).stream()
                .map(ThreadEntityDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ThreadEntityDTO findById(Long id) {
        ThreadEntity entity = threadEntityRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("해당 게시물이 없습니다 id: " + id ));
        return new ThreadEntityDTO(entity);
    }

}
