// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.VerificationRequestRepository;
// import com.example.demo.service.*;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class VerificationRequestServiceImpl implements VerificationRequestService {
//     private final VerificationRequestRepository requestRepo;
//     private final CredentialRecordService credentialService;
//     private final VerificationRuleService ruleService;
//     private final AuditTrailService auditService;

//     public VerificationRequestServiceImpl(VerificationRequestRepository requestRepo, 
//                                           CredentialRecordService credentialService,
//                                           VerificationRuleService ruleService,
//                                           AuditTrailService auditService) {
//         this.requestRepo = requestRepo;
//         this.credentialService = credentialService;
//         this.ruleService = ruleService;
//         this.auditService = auditService;
//     }

//     @Override
//     public VerificationRequest initiateVerification(VerificationRequest request) {
//         return requestRepo.save(request);
//     }

//     @Override
//     public VerificationRequest processVerification(Long requestId) {
//         VerificationRequest request = requestRepo.findById(requestId)
//                 .orElseThrow(() -> new RuntimeException("Request not found"));

//         // Match credential using service to support Test Mock behavior
//         CredentialRecord credential = credentialService.getAllCredentials().stream()
//                 .filter(c -> c.getId().equals(request.getCredentialId()))
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("Credential not found"));

//         // Trigger rule fetch (logic requirement)
//         List<VerificationRule> rules = ruleService.getActiveRules();

//         boolean expired = credential.getExpiryDate() != null && credential.getExpiryDate().isBefore(LocalDate.now());

//         if (expired) {
//             request.setStatus("FAILED");
//         } else {
//             request.setStatus("SUCCESS");
//         }

//         AuditTrailRecord audit = new AuditTrailRecord();
//         audit.setCredentialId(credential.getId());
//         audit.setLoggedAt(LocalDateTime.now());
//         auditService.logEvent(audit);

//         return requestRepo.save(request);
//     }

//     @Override
//     public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
//         return requestRepo.findByCredentialId(credentialId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository requestRepository;

    @Autowired
    private CredentialRecordRepository credentialRepository;

    @Override
    public VerificationRequest createRequest(VerificationRequest request) {
        request.setRequestDate(LocalDateTime.now());
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = requestRepository.findById(requestId).orElse(null);
        if (request == null) return null;

        CredentialRecord credential = request.getCredentialRecord();
        
        // Validation Logic
        boolean isValid = true;
        
        // Check Expiry
        // FIX: Use LocalDateTime.now() for comparison
        if (credential.getExpiryDate() != null && credential.getExpiryDate().isBefore(LocalDateTime.now())) {
            isValid = false;
        }

        // Check Status
        if (!"ACTIVE".equalsIgnoreCase(credential.getStatus())) {
            isValid = false;
        }

        request.setStatus(isValid ? "VERIFIED" : "REJECTED");
        request.setProcessedDate(LocalDateTime.now());
        
        return requestRepository.save(request);
    }

    @Override
    public VerificationRequest getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return requestRepository.findByCredentialRecordId(credentialId);
    }
}