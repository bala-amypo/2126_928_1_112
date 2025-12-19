package com.example.demo.controller;

import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService verificationRequestService;

    @GetMapping("/verify/{id}")
    public String verifyRequest(@PathVariable Long id) {
        return verificationRequestService.processRequest(id);
    }
}
