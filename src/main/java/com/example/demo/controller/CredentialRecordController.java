package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

@RestController
public class CredentialRecordController {

    private CredentialRecordService service;

    public CredentialRecordController(CredentialRecordService service) {
        this.service = service;
    }

    @PostMapping("/api/credentials")
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return service.createCredential(record);
    }

    @GetMapping("/api/credentials")
    public List<CredentialRecord> getAll() {
        return service.getAllCredentials();
    }

    @GetMapping("/api/credentials/code/{code}")
    public CredentialRecord getByCode(@PathVariable String code) {
        return service.getCredentialByCode(code);
    }
}
