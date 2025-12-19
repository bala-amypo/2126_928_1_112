package com.example.demo.service;

import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditTrailService {

    private final AuditTrailRecordRepository repository;

    public AuditTrailService(AuditTrailRecordRepository repository) {
        this.repository = repository;
    }
}
