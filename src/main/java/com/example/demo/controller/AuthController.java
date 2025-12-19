package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody User user) {
        return "dummy-token";
    }
}
