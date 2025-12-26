// // package com.example.demo.service;

// // import java.util.List;
// // import com.example.demo.entity.CredentialRecord;

// // public interface CredentialRecordService {

// //     CredentialRecord createCredential(CredentialRecord record);

// //     CredentialRecord updateCredential(Long id, CredentialRecord update);

// //     List<CredentialRecord> getCredentialsByHolder(Long holderId);

// //     CredentialRecord getCredentialByCode(String code);
// // }
// package com.example.demo.service.impl;

// import com.example.demo.entity.CredentialRecord;
// import com.example.demo.repository.CredentialRecordRepository;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class CredentialRecordServiceImpl {
//     private final CredentialRecordRepository repository;

//     public CredentialRecordServiceImpl(CredentialRecordRepository repository) {
//         this.repository = repository;
//     }

//     public CredentialRecord createCredential(CredentialRecord record) {
//         // Rule: If expiryDate is before today, set status EXPIRED [cite: 163]
//         if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
//             record.setStatus("EXPIRED");
//         } 
//         // Rule: If status is null and not expired, default to VALID [cite: 164]
//         else if (record.getStatus() == null) {
//             record.setStatus("VALID");
//         }
//         return repository.save(record);
//     }

//     public CredentialRecord updateCredential(Long id, CredentialRecord update) {
//         CredentialRecord existing = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Not found"));
//         // Copy fields
//         if(update.getCredentialCode() != null) existing.setCredentialCode(update.getCredentialCode());
//         return repository.save(existing);
//     }
    
//     public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
//         return repository.findByHolderId(holderId);
//     }
    
//     public CredentialRecord getCredentialByCode(String code) {
//         return repository.findByCredentialCode(code).orElse(null);
//     }
// }
public List<CredentialRecord> getAllCredentials() {
        return repository.findAll();
    }