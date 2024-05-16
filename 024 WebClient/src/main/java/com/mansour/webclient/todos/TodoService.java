package com.mansour.webclient.todos;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.mansour.webclient.shared.base.BaseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService implements BaseService<Todo, Long> {
    private final WebClient webClient;
    private final String TODOS_URI = "/todos";

    public TodoService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Todo> findAll() {
        return webClient.get().uri(TODOS_URI).retrieve().bodyToFlux(Todo.class);
    }

    @Override
    public Mono<Todo> getById(Long id) {
        return webClient.get().uri(TODOS_URI + "/" + id).retrieve().bodyToMono(Todo.class);
    }

    @Override
    public Mono<Todo> create(Todo t) {
        return webClient.post().uri(TODOS_URI).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(t)).retrieve().bodyToMono(Todo.class);

    }

    @Override
    public Mono<Todo> delete(Long id) {
        return webClient.delete().uri(TODOS_URI + "/" + id).retrieve().bodyToMono(Todo.class);

    }

    @Override
    public Mono<Todo> update(Todo t) {
        return webClient.put().uri(TODOS_URI + "/" + t.getId())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(t))
                .retrieve()
                .bodyToMono(Todo.class);
    }

}
