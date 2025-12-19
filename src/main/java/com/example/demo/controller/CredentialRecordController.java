package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

@RestController
public class CredentialRecordController {

    private final CredentialRecordService service;

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
    public ResponseEntity<CredentialRecord> getByCode(@PathVariable String code) {
        return service.getCredentialByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
