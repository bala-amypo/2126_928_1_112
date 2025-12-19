package com.example.demo.controller;

import com.example.demo.service.AuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditTrailController {

    @Autowired
    private AuditTrailService service;

    @GetMapping("/logs")
    public List<String> getAllLogs() {
        return service.getAllLogs();
    }
}
