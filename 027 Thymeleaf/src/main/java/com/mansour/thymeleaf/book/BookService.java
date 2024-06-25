package com.mansour.thymeleaf.book;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.thymeleaf.shared.base.BaseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService implements BaseService<Book, Long> {
    private final BookJPARepository bookJPARepository;

    @Override
    public Book create(Book obj) {
        return bookJPARepository.save(obj);
    }

    @Override
    public List<Book> findAll() {
        return bookJPARepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id:%s not found".formatted(id)));
    }

    @Override
    public Book update(Book obj) {
        return bookJPARepository.save(obj);

    }

    @Override
    public Book delete(Long id) {
        Book book = bookJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id:%s not found".formatted(id)));
        bookJPARepository.deleteById(id);
        return book;
    }

}
