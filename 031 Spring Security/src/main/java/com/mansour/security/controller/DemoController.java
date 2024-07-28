package com.mansour.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class DemoController {

    @GetMapping("/login")
    public String login() {
        return "Logged in...";
    }

}
