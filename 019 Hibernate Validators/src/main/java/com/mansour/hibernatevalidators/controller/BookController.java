package com.mansour.hibernatevalidators.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.hibernatevalidators.base.BaseService;
import com.mansour.hibernatevalidators.entity.Author;
import com.mansour.hibernatevalidators.entity.Book;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BaseService<Book, Long> bookService;
    private final BaseService<Author, Long> authorService;

    public BookController(BaseService<Book, Long> bookService, BaseService<Author, Long> authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public Book create(@RequestBody @Valid Book book) {
        return bookService.create(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable @NotNull Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/{book-id}/authors/{author-id}")
    public Book update(@PathVariable(name = "book-id") @NotNull Long bookId,
            @PathVariable(name = "author-id") @NotNull Long authorId) {
        Book book = bookService.findById(bookId);
        Author author = authorService.findById(authorId);
        book.addAuthor(author);
        return bookService.update(book);
    }

}
