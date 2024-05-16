package com.mansour.resttemplate.shared.base;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> findAll();

    T getById(ID id);

    T create(T t);

    T delete(ID id);

    T update(T t);
}
