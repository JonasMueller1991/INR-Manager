package com.inr.inrmanager.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class InrDto implements DtoWithId {
    private Long Id;
    private Float inrValue;
    private LocalDate date;
}
