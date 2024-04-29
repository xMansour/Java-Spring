package com.mansour.hibernatevalidators.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.hibernatevalidators.base.BaseService;
import com.mansour.hibernatevalidators.entity.Author;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final BaseService<Author, Long> authorService;

    public AuthorController(BaseService<Author, Long> authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable @NotNull Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author create(@RequestBody @Valid Author author) {
        return authorService.create(author);
    }
}
