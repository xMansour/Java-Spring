package com.mansour.hibernatevalidators.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.hibernatevalidators.base.BaseService;
import com.mansour.hibernatevalidators.entity.Book;
import com.mansour.hibernatevalidators.repository.BookJPARepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService implements BaseService<Book, Long> {
    private BookJPARepository bookJPARepository;

    public BookService(BookJPARepository bookJPARepository) {
        this.bookJPARepository = bookJPARepository;
    }

    @Override
    public Book create(Book t) {
        return bookJPARepository.save(t);
    }

    @Override
    public List<Book> findAll() {
        return bookJPARepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id:%s not found.".formatted(id)));
    }

    @Override
    public Book update(Book t) {
        return bookJPARepository.save(t);
    }

    @Override
    public Book delete(Long id) {
        Book book = bookJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id:%s not found.".formatted(id)));
        bookJPARepository.deleteById(id);
        return book;
    }

}
