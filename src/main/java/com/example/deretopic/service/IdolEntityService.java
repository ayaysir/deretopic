package com.example.deretopic.service;

import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
import com.example.deretopic.web.dto.IdolRequestDTO;
import com.example.deretopic.web.dto.IdolResponseDTO;
import com.example.deretopic.web.dto.IdolSimpleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IdolEntityService {

    private final IdolEntityRepository idolEntityRepository;

    @Transactional
    public Long save(IdolRequestDTO dto) {
        return idolEntityRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(IdolRequestDTO dto) {
        IdolEntity entity = idolEntityRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("아이돌이 없습니다. id: " + dto.getId()) );
        entity.update(dto);
        return entity.getId();
    }

    public String findNameKoByNameJa(String nameJa) throws IndexOutOfBoundsException{
        return idolEntityRepository.findByName(nameJa).get(0).getNameKo();
    }

    @Transactional(readOnly = true)
    public List<IdolSimpleResponseDTO> findAllSimple() {
        return idolEntityRepository.findAll().stream()
                .map(IdolSimpleResponseDTO::new)
                .collect(Collectors.toList());

    }

    public IdolResponseDTO findById(Long id) {
        IdolEntity entity = idolEntityRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException("아이돌이 없습니다. id=" + id));
        return new IdolResponseDTO(entity);
    }

}
