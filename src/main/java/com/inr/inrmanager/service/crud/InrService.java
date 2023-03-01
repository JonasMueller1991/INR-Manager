package com.inr.inrmanager.service.crud;

import com.inr.inrmanager.controller.crud.InrController;
import com.inr.inrmanager.dtos.InrDto;
import com.inr.inrmanager.jpa.model.Inr;
import com.inr.inrmanager.repository.InrRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.inr.inrmanager.controller.crud.InrController.mapToDto;
import static com.inr.inrmanager.controller.crud.InrController.mapToEntity;

@Slf4j
@NoArgsConstructor
@Service
public class InrService {
    @Autowired
    private InrRepository inrRepository;

    public List<InrDto> read() {
        return inrRepository.findAll().stream().map(InrController::mapToDto).toList();
    }

    public InrDto findById(Long id) {
        Inr inr = inrRepository.findById(id).orElseThrow(() -> new RuntimeException("INR value not found."));
        return mapToDto(inr);
    }

    public InrDto create(InrDto inrDto) {
        Inr inr = mapToEntity(inrDto, new Inr());
        inr = inrRepository.save(inr);
        log.debug("Created {}: {}", inrDto.getClass().getSimpleName(), inr);
        inrDto.setId(inr.getId());

        return inrDto;
    }

    public InrDto update(InrDto inrDto) {
        Inr inr = inrRepository.findById(inrDto.getId()).orElseThrow(() -> new RuntimeException("INR value not found."));
        inr = mapToEntity(inrDto, inr);
        inrRepository.save(inr);
        return inrDto;
    }

    public void delete(Long inrId) {
        Inr inr = inrRepository.findById(inrId).orElseThrow(() -> new RuntimeException("INR value not found"));
        inrRepository.delete(inr);
    }

}
