package com.example.demo.service.impl;

import com.example.demo.service.AuditTrailService;
import org.springframework.stereotype.Service;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

    @Override
    public void logAction(String action) {
        // Log to console for demo
        System.out.println("Audit Log: " + action);
    }
}
