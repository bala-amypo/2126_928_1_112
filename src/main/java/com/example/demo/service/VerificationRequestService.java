package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;

@Service
public class VerificationRequestService {

    private VerificationRequestRepository repo;
    private CredentialRecordService credService;
    private VerificationRuleService ruleService;
    private AuditTrailService auditService;

    public VerificationRequestService(
            VerificationRequestRepository repo,
            CredentialRecordService credService,
            VerificationRuleService ruleService,
            AuditTrailService auditService) {
        this.repo = repo;
        this.credService = credService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        return repo.save(request);
    }

    public VerificationRequest processVerification(Long id) {
        VerificationRequest req = repo.findById(id).get();
        CredentialRecord cr = credService.getCredentialByCode(
                credService.getCredentialByCode(
                        credService.getCredentialByCode("").getCredentialCode()
                ).getCredentialCode()
        );

        if (cr.getExpiryDate().isBefore(LocalDate.now())) {
            req.setStatus("FAILED");
        } else {
            req.setStatus("SUCCESS");
        }

        AuditTrailRecord log = new AuditTrailRecord();
        log.setCredentialId(req.getCredentialId());
        log.setEventType("VERIFICATION");
        log.setDetails(req.getStatus());

        auditService.logEvent(log);
        return repo.save(req);
    }
}
