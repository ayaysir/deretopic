package com.example.deretopic.service;

import com.example.deretopic.domain.uwasa.UwasaEntity;
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

    @Transactional
    public Long updateTTSOnly(Long id, String ttsFileName) {
        UwasaEntity entity = uwasaEntityRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("해당 소문이 없습니다. id=" + id));

        entity.updateOnlyTTS(ttsFileName);

        return id;
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

    @Transactional(readOnly = true)
    public UwasaEntityDTO findById(Long id) {
        UwasaEntity entity = uwasaEntityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 소문이 없습니다. id=" + id));

        return new UwasaEntityDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<UwasaEntityDTO> findUwasaByKeyword(String keyword, PageRequest pageRequest) {
        List<UwasaEntity> list = uwasaEntityRepository
                .findByUwasaJaContainingOrUwasaKoContaining(keyword, keyword, pageRequest);

        List<UwasaEntityDTO> dtoList = list.stream()
                .map(UwasaEntityDTO::new)
                .collect(Collectors.toList());

        return dtoList;
    }


}
