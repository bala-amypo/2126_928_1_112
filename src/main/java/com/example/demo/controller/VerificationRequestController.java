package com.example.demo.controller;

import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService verificationRequestService;

    @GetMapping("/process/{id}")
    public String processRequest(@PathVariable Long id) {
        return verificationRequestService.processRequest(id);
    }
}
