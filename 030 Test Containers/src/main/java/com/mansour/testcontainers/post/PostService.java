package com.mansour.testcontainers.post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post with id:%s not found.".formatted(id)));
    }


    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public void update(long id, Post post) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post updatedPost = new Post(existingPost.get().getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getAuthor());
            postRepository.save(updatedPost);
        } else throw new PostNotFoundException("Post with id:%s not found.".formatted(id));
    }
}
