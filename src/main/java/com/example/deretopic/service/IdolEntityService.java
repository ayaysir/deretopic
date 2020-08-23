package com.example.deretopic.service;

import com.example.deretopic.domain.common.ThreeSize;
import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
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
    public Long save(String name, String nameKo) {
        return idolEntityRepository.save(IdolEntity.builder()
                .name(name).nameKo(nameKo)
                .threeSize(ThreeSize.builder().bust(0).hip(0).waist(0).build())
                .build()).getId();
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
}
