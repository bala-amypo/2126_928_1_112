// package com.example.demo.service.impl;

// import com.example.demo.entity.CredentialRecord;
// import com.example.demo.repository.CredentialRecordRepository;
// import com.example.demo.service.CredentialRecordService;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.util.List;

// @Service
// public class CredentialRecordServiceImpl implements CredentialRecordService {
//     private final CredentialRecordRepository repository;

//     public CredentialRecordServiceImpl(CredentialRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public CredentialRecord createCredential(CredentialRecord record) {
//         if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
//             record.setStatus("EXPIRED");
//         } else if (record.getStatus() == null) {
//             record.setStatus("VALID");
//         }
//         return repository.save(record);
//     }

//     @Override
//     public CredentialRecord updateCredential(Long id, CredentialRecord update) {
//         CredentialRecord existing = repository.findById(id)
//                 .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Not found"));
//         if(update.getCredentialCode() != null) existing.setCredentialCode(update.getCredentialCode());
//         return repository.save(existing);
//     }

//     @Override
//     public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
//         return repository.findByHolderId(holderId);
//     }

//     @Override
//     public CredentialRecord getCredentialByCode(String code) {
//         return repository.findByCredentialCode(code).orElse(null);
//     }

//     @Override
//     public List<CredentialRecord> getAllCredentials() {
//         return repository.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository repository;

    @Override
    public CredentialRecord save(CredentialRecord credential) {
        // Ensure default status if missing
        if (credential.getStatus() == null) {
            credential.setStatus("ACTIVE");
        }
        return repository.save(credential);
    }

    @Override
    public Optional<CredentialRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CredentialRecord> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<CredentialRecord> findExpiredBefore(LocalDateTime dateTime) {
        // FIX: Ensure the parameter matches the repository expectation (LocalDateTime)
        return repository.findByExpiryDateBefore(dateTime);
    }

    public CredentialRecord update(Long id, CredentialRecord update) {
        return repository.findById(id).map(existing -> {
            // FIX: Use getCode() instead of getCredentialCode()
            if (update.getCode() != null) existing.setCode(update.getCode());
            if (update.getStatus() != null) existing.setStatus(update.getStatus());
            if (update.getType() != null) existing.setType(update.getType());
            if (update.getExpiryDate() != null) existing.setExpiryDate(update.getExpiryDate());
            if (update.getMetadata() != null) existing.setMetadata(update.getMetadata());
            return repository.save(existing);
        }).orElse(null);
    }
}