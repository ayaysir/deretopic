package com.example.deretopic.service;

import com.example.deretopic.domain.idol.IdolEntity;
import com.example.deretopic.domain.idol.IdolEntityRepository;
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
    private final IdolEntityRepository idolEntityRepository;

    @Transactional
    public Long save(UwasaEntitySaveDTO uwasaEntitySaveDTO) {
        Long idolId = uwasaEntitySaveDTO.getIdolId();
        System.out.println("idol id >>>>> " + idolId);
        if(idolId == null) {

        }
        IdolEntity idol = idolEntityRepository.findById(idolId)
                .orElseThrow(() -> new IllegalStateException("아이돌이 없습니다. id:" + idolId));
        uwasaEntitySaveDTO.setIdol(idol);
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

    @Transactional(readOnly = true)
    public List<UwasaEntityDTO> findByIdolJaName(String idolName) {
        List<UwasaEntity> list = uwasaEntityRepository.findByIdolNameJa(idolName);

        return list.stream()
                .map(UwasaEntityDTO::new)
                .collect(Collectors.toList());
    }


}
