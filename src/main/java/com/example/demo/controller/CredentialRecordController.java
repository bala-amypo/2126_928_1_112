package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService service;

    @PostMapping
    public CredentialRecord createCredential(@RequestBody CredentialRecord record) {
        return service.createCredential(record);
    }

    @GetMapping
    public List<CredentialRecord> getAllCredentials() {
        return service.getAllCredentials();
    }

    @GetMapping("/{code}")
    public CredentialRecord getCredentialByCode(@PathVariable String code) {
        return service.getCredentialByCode(code);
    }
}
