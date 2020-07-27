package com.example.deretopic.service;

import com.example.deretopic.domain.uwasa.UwasaRepository;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import com.example.deretopic.web.dto.UwasaEntitySaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UwasaEntityService {

    private final UwasaRepository uwasaRepository;

    @Transactional
    public Long save(UwasaEntitySaveDTO uwasaEntitySaveDTO) {
        return uwasaRepository.save(uwasaEntitySaveDTO.toEntity()).getId();
    }

    @Transactional
    public List<UwasaEntityDTO> findAll() {
        return uwasaRepository.findAll().stream()
                .map(UwasaEntityDTO::new)
                .collect(Collectors.toList());
    }
}
