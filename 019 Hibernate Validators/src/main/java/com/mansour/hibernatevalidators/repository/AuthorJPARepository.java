package com.mansour.hibernatevalidators.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansour.hibernatevalidators.entity.Author;

public interface AuthorJPARepository extends JpaRepository<Author, Long> {

}
