package com.example.demo.service.impl;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    @Autowired
    private CredentialRecordService credentialRecordService;

    @Autowired
    private VerificationRuleService verificationRuleService;

    @Autowired
    private AuditTrailService auditTrailService;

    @Override
    public String processRequest(Long requestId) {
        if (requestId == null) return "Invalid request";

        String requestIdStr = String.valueOf(requestId);

        boolean credentialExists = credentialRecordService.credentialExists(requestId);
        boolean rulesPassed = verificationRuleService.applyRules(requestId);

        auditTrailService.logAction("Processed request ID: " + requestIdStr);

        if (credentialExists && rulesPassed) {
            return "Verification successful for request " + requestIdStr;
        } else {
            return "Verification failed for request " + requestIdStr;
        }
    }
}
