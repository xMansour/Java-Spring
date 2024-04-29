package com.mansour.security.base;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface BaseService<T, ID> {
    List<T> findAll();

    default T findByName(String name) {
        return null;
    }

    T getById(ID id) throws EntityNotFoundException;

    T create(T t);

    T delete(ID id);

    T update(T t);

}
