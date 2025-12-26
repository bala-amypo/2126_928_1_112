// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.AuditTrailRecord;

// public interface AuditTrailService {

//     AuditTrailRecord logEvent(AuditTrailRecord record);

//     List<AuditTrailRecord> getLogsByCredential(Long credentialId);
// }
package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditTrailServiceImpl {
    private final AuditTrailRecordRepository repo;

    public AuditTrailServiceImpl(AuditTrailRecordRepository repo) {
        this.repo = repo;
    }

    public AuditTrailRecord logEvent(AuditTrailRecord record) {
        if (record.getLoggedAt() == null) {
            record.setLoggedAt(LocalDateTime.now());
        }
        return repo.save(record);
    }
    
    public List<AuditTrailRecord> getLogsByCredential(Long credentialId) {
        return repo.findByCredentialId(credentialId);
    }
}