package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;

@Service
public class AuditTrailService {

    private AuditTrailRecordRepository repo;

    public AuditTrailService(AuditTrailRecordRepository repo) {
        this.repo = repo;
    }

    public AuditTrailRecord logEvent(AuditTrailRecord record) {
        return repo.save(record);
    }

    public List<AuditTrailRecord> getAllLogs() {
        return repo.findAll();
    }
}
