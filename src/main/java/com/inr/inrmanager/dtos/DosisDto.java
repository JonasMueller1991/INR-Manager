package com.inr.inrmanager.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DosisDto implements DtoWithId {
    private Long id;
    private Integer dosis;
    private LocalDate date;
}
