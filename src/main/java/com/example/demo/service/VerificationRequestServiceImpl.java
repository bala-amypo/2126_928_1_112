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
        String requestIdStr = String.valueOf(requestId);

        boolean credentialOk = credentialRecordService.credentialExists(requestId);
        boolean rulesPassed = verificationRuleService.applyRules(requestId);
        auditTrailService.logAction("Processed request " + requestIdStr);

        if (credentialOk && rulesPassed) {
            return "Request " + requestIdStr + " verified successfully!";
        } else {
            return "Request " + requestIdStr + " verification failed!";
        }
    }
}
