package com.example.learn.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Security !";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome admin !";
    }
}
