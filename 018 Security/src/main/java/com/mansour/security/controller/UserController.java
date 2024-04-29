package com.mansour.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.security.base.BaseService;
import com.mansour.security.entity.AppUser;

@RestController
@RequestMapping("/api/v1/security-users")
public class UserController {
    private final BaseService<AppUser, Long> userService;

    public UserController(@Qualifier("userServiceImpl") BaseService<AppUser, Long> userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<AppUser> findAll() {
        return userService.findAll();
    }

}
