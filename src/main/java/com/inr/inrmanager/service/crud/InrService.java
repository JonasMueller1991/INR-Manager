package com.inr.inrmanager.service.crud;

import com.inr.inrmanager.dtos.InrDto;
import com.inr.inrmanager.jpa.model.Inr;
import com.inr.inrmanager.repository.InrRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Slf4j
@NoArgsConstructor
@Service
public class InrService extends AbstractCrudService<InrDto, Inr> {
    @Autowired
    private InrRepository inrRepository;

    @Override
    protected Class<InrDto> getDtoclass() {
        return InrDto.class;
    }

    @Override
    protected Class<Inr> getEntityClass() {
        return Inr.class;
    }

    @Override
    protected JpaRepository<Inr, Long> getRepository() {
        return inrRepository;
    }

    @Override
    public InrDto mapToDto(Inr inr) {
        return InrDto.builder()
                .Id(inr.getId())
                .inrValue(inr.getInrValue())
                .date(inr.getDate())
                .build();
    }

    @Override
    public Inr mapToEntity(InrDto inrDto, Inr inr) {
        inr.setInrValue(inrDto.getInrValue());
        inr.setDate(inrDto.getDate());
        return inr;
    }
}
