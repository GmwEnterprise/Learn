package com.example.learn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonApi {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Security !";
    }
}
