package com.mansour.webclient.todos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Todo>> getTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Flux<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<Todo>> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.create(todo));
    }

    @PutMapping
    public ResponseEntity<Mono<Todo>> updateTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Todo>> deleteTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.delete(id));
    }

}
