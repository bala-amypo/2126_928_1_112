package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;

@RestController
public class AuditTrailController {

    private AuditTrailService service;

    public AuditTrailController(AuditTrailService service) {
        this.service = service;
    }

    @GetMapping("/api/audit")
    public List<AuditTrailRecord> getAll() {
        return service.getAllLogs();
    }
}
