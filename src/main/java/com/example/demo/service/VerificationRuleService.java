package com.example.demo.service;

public interface VerificationRuleService {

    /**
     * Apply verification rules for a given request ID
     * @param requestId ID of the verification request
     * @return true if all rules pass
     */
    boolean applyRules(Long requestId);
}
