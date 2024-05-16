package com.mansour.webclient.shared.base;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseService<T, ID> {
    Flux<T> findAll();

    Mono<T> getById(ID id);

    Mono<T> create(T t);

    Mono<T> delete(ID id);

    Mono<T> update(T t);
}
