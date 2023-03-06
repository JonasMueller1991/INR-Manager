package com.inr.inrmanager.service.crud;

import com.inr.inrmanager.dtos.DtoWithId;
import com.inr.inrmanager.jpa.model.DbEntity;
import jakarta.persistence.Entity;
import lombok.SneakyThrows;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T extends DtoWithId, K extends DbEntity> implements CrudService<T> {

    protected abstract Class<T> getDtoclass();

    protected abstract Class<K> getEntityClass();

    protected abstract JpaRepository<K, Long> getRepository();

    protected abstract T mapToDto(K entity);

    protected abstract K mapToEntity(T dto, K entity);

    @Override
    public List<T> read() {
        List<K> entities = getRepository().findAll();
        return entities.stream().map(this::mapToDto).toList();
    }

    @Override
    public T read(Long id) {
        return mapToDto(findDataBaseEntityById(id));
    }

    @Override
    public T create(T dto) {
        K entity = mapToEntity(dto, createEntityInstance());
        entity = getRepository().save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public T update(T dto) {
        K modifiedEntity = mapToEntity(dto, findDataBaseEntityById(dto.getId()));
        getRepository().save(modifiedEntity);
        return dto;
    }


    @Override
    public void delete(Long id) {
        K entity = findDataBaseEntityById(id);
        getRepository().delete(entity);
    }

    protected K findDataBaseEntityById(Long id) {
        Optional<K> entity = getRepository().findById(id);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException(String.format("Entity with ID %d not found", id));
        }
        return entity.get();
    }

    @SneakyThrows
    private K createEntityInstance() {
        return getEntityClass().getDeclaredConstructor().newInstance();
    }
}
