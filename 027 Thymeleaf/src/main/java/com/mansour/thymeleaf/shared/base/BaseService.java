package com.mansour.thymeleaf.shared.base;

import java.util.List;

public interface BaseService<T, I> {
    T create(T obj);

    List<T> findAll();

    T findById(I id);

    T update(T obj);

    T delete(I id);

}
