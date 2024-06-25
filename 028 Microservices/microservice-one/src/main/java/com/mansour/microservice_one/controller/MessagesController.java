package com.mansour.microservice_one.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/messages")
public class MessagesController {

    @GetMapping
    public String getMessage() {
        return "Message from Microservice one";
    }

}
