package com.mansour.caching.shared.base;

import java.util.List;

import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public interface BaseService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    T delete(ID id);

}
