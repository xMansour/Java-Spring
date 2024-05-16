package com.mansour.resttemplate.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mansour.resttemplate.shared.base.BaseService;

@Service
@PropertySource(value = "application.properties")
public class PostService implements BaseService<Post, Long> {
    private final RestTemplate resttemplate;
    @Value("${posts-service.base-url}")
    private String POSTS_SERVICE_BASE_URL;

    public PostService(RestTemplate restTemplate) {
        this.resttemplate = restTemplate;
    }

    @Override
    public List<Post> findAll() {
        return resttemplate.getForEntity(POSTS_SERVICE_BASE_URL, List.class).getBody();

    }

    @Override
    public Post getById(Long id) {
        return resttemplate.getForObject(POSTS_SERVICE_BASE_URL + "/" + id, Post.class);
    }

    @Override
    public Post create(Post t) {
        return resttemplate.postForObject(POSTS_SERVICE_BASE_URL, t, Post.class);
    }

    @Override
    public Post delete(Long id) {
        Post post = getById(id);
        resttemplate.delete(POSTS_SERVICE_BASE_URL + "/" + id);
        return post;
    }

    @Override
    public Post update(Post t) {
        resttemplate.put(POSTS_SERVICE_BASE_URL, t);
        return getById(t.id());
    }

}
