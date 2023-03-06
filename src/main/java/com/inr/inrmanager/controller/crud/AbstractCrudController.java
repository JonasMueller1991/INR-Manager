package com.inr.inrmanager.controller.crud;

import com.inr.inrmanager.dtos.DtoWithId;
import com.inr.inrmanager.service.crud.CrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@RestController
public abstract class AbstractCrudController<S extends CrudService<T>, T extends DtoWithId> {

    protected S service;

    @GetMapping
    public ResponseEntity<List<T>> get() {
        return ResponseEntity.ok(service.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody T dto) {
        if (dto.getId() != null) {
            return ResponseEntity.badRequest().body("Id must not be null.");
        }
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody T dto) {
        if (dto.getId() == null) {
            return ResponseEntity.badRequest().body("Id must NOT be empty");
        }
        if (!Objects.equals(id, dto.getId())) {
            return ResponseEntity.badRequest().body("ID in body must match id in path");
        }
        return ResponseEntity.ok(service.update(dto));
    }
}
