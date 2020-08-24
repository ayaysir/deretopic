package com.example.deretopic.service;

import com.example.deretopic.domain.uwasa.UwasaEntityRepository;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import com.example.deretopic.web.dto.UwasaEntitySaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UwasaEntityService {

    private final UwasaEntityRepository uwasaEntityRepository;

    @Transactional
    public Long save(UwasaEntitySaveDTO uwasaEntitySaveDTO) {
        return uwasaEntityRepository.save(uwasaEntitySaveDTO.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<UwasaEntityDTO> findAll() {
        return uwasaEntityRepository.findAll().stream()
                .map(UwasaEntityDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UwasaEntityDTO> findByPageRequest(PageRequest pageRequest) {
        return uwasaEntityRepository.findAll(pageRequest).stream()
                .map(UwasaEntityDTO::new)
                .collect(Collectors.toList());
    }


}
