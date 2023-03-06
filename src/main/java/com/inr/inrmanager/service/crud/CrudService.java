package com.inr.inrmanager.service.crud;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CrudService<T> {
    List<T> read();

    T read(Long id);

    @Transactional
    T create(T dto);

    @Transactional
    T update(T dto);

    @Transactional
    void delete(Long id);
}
