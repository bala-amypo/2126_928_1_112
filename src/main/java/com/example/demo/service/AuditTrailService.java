package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;

@Service
public class AuditTrailService {

    private final AuditTrailRecordRepository repository;

    public AuditTrailService(AuditTrailRecordRepository repository) {
        this.repository = repository;
    }

    // USED BY AuditTrailController
    public List<AuditTrailRecord> getAllLogs() {
        return repository.findAll();
    }

    // USED BY VerificationRequestService
    public void logEvent(AuditTrailRecord record) {
        repository.save(record);
    }
}
