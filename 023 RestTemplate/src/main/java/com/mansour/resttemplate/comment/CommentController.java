package com.mansour.resttemplate.comment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.resttemplate.shared.base.BaseService;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final BaseService<Comment, Long> commentService;

    public CommentController(BaseService<Comment, Long> commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getById(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment Comment) {
        return commentService.create(Comment);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment Comment) {
        return commentService.update(Comment);
    }

    @DeleteMapping("/{id}")
    public Comment deleComment(@PathVariable Long id) {
        return commentService.delete(id);
    }

}
