package com.mansour.hibernatevalidators.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.hibernatevalidators.base.BaseService;
import com.mansour.hibernatevalidators.entity.Author;
import com.mansour.hibernatevalidators.repository.AuthorJPARepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService implements BaseService<Author, Long> {
    private AuthorJPARepository authorJPARepository;

    public AuthorService(AuthorJPARepository authorJPARepository) {
        this.authorJPARepository = authorJPARepository;
    }

    @Override
    public Author create(Author t) {
        return authorJPARepository.save(t);
    }

    @Override
    public List<Author> findAll() {
        return authorJPARepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id:%s not found.".formatted(id)));
    }

    @Override
    public Author update(Author t) {
        return authorJPARepository.save(t);
    }

    @Override
    public Author delete(Long id) {
        Author author = authorJPARepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id:%s not found.".formatted(id)));
        authorJPARepository.deleteById(id);
        return author;

    }

}
