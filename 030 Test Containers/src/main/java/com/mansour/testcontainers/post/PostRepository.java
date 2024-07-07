package com.mansour.testcontainers.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    List<Post> findByTitleContaining(String title);
}
