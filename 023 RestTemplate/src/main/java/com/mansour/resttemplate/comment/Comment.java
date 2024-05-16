package com.mansour.resttemplate.comment;

public record Comment(Long postId, Long id, String name, String email, String body) {

}
