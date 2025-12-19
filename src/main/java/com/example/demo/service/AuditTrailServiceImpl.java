package com.example.demo.service.impl;

import com.example.demo.service.AuditTrailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

    private final List<String> logs = new ArrayList<>();

    @Override
    public void logAction(String action) {
        logs.add(action);
        System.out.println("Audit Log: " + action);
    }

    @Override
    public List<String> getAllLogs() {
        return new ArrayList<>(logs);
    }
}
