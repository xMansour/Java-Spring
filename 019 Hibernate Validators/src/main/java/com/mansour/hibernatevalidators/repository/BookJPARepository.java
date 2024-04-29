package com.mansour.hibernatevalidators.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansour.hibernatevalidators.entity.Book;

public interface BookJPARepository extends JpaRepository<Book, Long> {

}
