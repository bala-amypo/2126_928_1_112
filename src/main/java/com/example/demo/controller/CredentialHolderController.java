package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;

@RestController
public class CredentialHolderController {

    private CredentialHolderProfileService service;

    public CredentialHolderController(CredentialHolderProfileService service) {
        this.service = service;
    }

    @PostMapping("/api/holders")
    public CredentialHolderProfile create(@RequestBody CredentialHolderProfile profile) {
        return service.createHolder(profile);
    }

    @GetMapping("/api/holders")
    public List<CredentialHolderProfile> getAll() {
        return service.getAllHolders();
    }
}
