package com.mansour.thymeleaf.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<Book, Long> {

}
