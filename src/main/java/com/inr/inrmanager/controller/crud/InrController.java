package com.inr.inrmanager.controller.crud;

import com.inr.inrmanager.dtos.InrDto;
import com.inr.inrmanager.jpa.model.Inr;
import com.inr.inrmanager.service.crud.InrService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.inr.inrmanager.UriConstants.UriConstants.INR_VALUE_BASE_URI;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(INR_VALUE_BASE_URI)
public class InrController {
    private InrService inrService;


    @GetMapping
    public ResponseEntity<List<InrDto>> get() {
        return ResponseEntity.ok(inrService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InrDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(inrService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody InrDto inrDto) {
        if (inrDto.getId() != null) {
            return ResponseEntity.badRequest().body("Id must not be null.");
        }
        return ResponseEntity.ok(inrService.create(inrDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        inrService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    ResponseEntity<?> put(@RequestBody InrDto inrDto) {
        return ResponseEntity.ok(inrService.update(inrDto));
    }

    public static InrDto mapToDto(Inr inr) {
        return InrDto.builder()
                .Id(inr.getId())
                .inrValue(inr.getInrValue())
                .date(inr.getDate())
                .build();
    }

    public static Inr mapToEntity(InrDto inrDto, Inr inr) {
        inr.setInrValue(inrDto.getInrValue());
        inr.setDate(inrDto.getDate());
        return inr;
    }
}
