package com.inr.inrmanager.service.crud;

import com.inr.inrmanager.dtos.DosisDto;
import com.inr.inrmanager.jpa.model.Dosis;
import com.inr.inrmanager.repository.DosisRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Slf4j
@NoArgsConstructor
@Service
public class DosisService extends AbstractCrudService<DosisDto, Dosis>{
    @Autowired
    private DosisRepository dosisRepository;
    @Override
    protected Class<DosisDto> getDtoclass() {
        return DosisDto.class;
    }

    @Override
    protected Class<Dosis> getEntityClass() {
        return Dosis.class;
    }

    @Override
    protected JpaRepository<Dosis, Long> getRepository() {
        return dosisRepository;
    }

    @Override
    protected DosisDto mapToDto(Dosis entity) {
        return DosisDto.builder()
                .dosis(entity.getDosis())
                .date(entity.getDate())
                .build();
    }

    @Override
    protected Dosis mapToEntity(DosisDto dto, Dosis entity) {
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        return entity;
    }
}
