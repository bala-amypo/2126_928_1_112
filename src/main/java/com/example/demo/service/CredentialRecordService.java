// package com.example.demo.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.CredentialRecord;
// import com.example.demo.repository.CredentialRecordRepository;

// @Service
// public class CredentialRecordService {

//     private CredentialRecordRepository repo;

//     public CredentialRecordService(CredentialRecordRepository repo) {
//         this.repo = repo;
//     }

//     public CredentialRecord createCredential(CredentialRecord record) {
//         if (record.getStatus() == null) {
//             record.setStatus("VALID");
//         }
//         return repo.save(record);
//     }

//     public List<CredentialRecord> getAllCredentials() {
//         return repo.findAll();
//     }

//     public CredentialRecord getCredentialByCode(String code) {
//         return repo.findByCredentialCode(code);
//     }

//     public List<CredentialRecord> getByHolder(Long holderId) {
//         return repo.findByHolderId(holderId);
//     }
// }
