package com.mansour.lombok.shared.base;

import java.util.List;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface BaseService<T, I> {
    List<T> findAll();

    T findById(I id);

    T create(T obj);

    T update(T obj);

    T delete(I id);
}
