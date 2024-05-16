package com.mansour.resttemplate.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mansour.resttemplate.shared.base.BaseService;

@Service
public class CommentService implements BaseService<Comment, Long> {
    private final RestTemplate restTemplate;
    @Value("${comments-service.base-url}")
    private String BASE_COMMENT_URL;

    public CommentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Comment> findAll() {
        return restTemplate.getForEntity(BASE_COMMENT_URL, List.class).getBody();
    }

    @Override
    public Comment getById(Long id) {
        return restTemplate.getForObject(BASE_COMMENT_URL, Comment.class);
    }

    @Override
    public Comment create(Comment t) {
        return restTemplate.postForObject(BASE_COMMENT_URL, t, Comment.class);
    }

    @Override
    public Comment delete(Long id) {
        Comment comment = getById(id);
        restTemplate.delete(BASE_COMMENT_URL + "/" + id);
        return comment;
    }

    @Override
    public Comment update(Comment t) {
        Comment comment = getById(t.id());
        restTemplate.put(BASE_COMMENT_URL, t);
        return comment;
    }

}
