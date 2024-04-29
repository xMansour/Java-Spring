package com.mansour.hibernatevalidators.base;

import java.util.List;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface BaseService<T, I> {

    T create(T t);

    List<T> findAll();

    T findById(I id);

    T update(T t);

    T delete(I id);

}
