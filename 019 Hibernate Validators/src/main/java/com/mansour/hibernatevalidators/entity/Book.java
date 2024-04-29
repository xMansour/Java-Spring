package com.mansour.hibernatevalidators.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mansour.hibernatevalidators.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "book")
public class Book extends BaseEntity<Long> {
    @NotBlank
    private String title;

    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors;

    public Book() {
    }

    public Book(@NotBlank String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Long authorId) {
        Author author = this.authors.stream().filter(authorObj -> authorObj.getId() == authorId).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No Author with id:%s".formatted(authorId)));
        if (author != null) {
            this.authors.remove(author);
            author.getBooks().remove(this);
        }
    }

}
