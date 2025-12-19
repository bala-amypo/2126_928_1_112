package com.example.demo.service;

import java.util.List;

public interface AuditTrailService {
    void logAction(String action);
    List<String> getAllLogs();
}
