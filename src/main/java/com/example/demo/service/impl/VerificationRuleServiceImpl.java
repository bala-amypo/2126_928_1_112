package com.example.demo.service.impl;

import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    @Override
    public boolean applyRules(Long requestId) {
        // Example: simple rule - request passes if requestId is even
        if (requestId == null) return false;
        return requestId % 2 == 0;
    }
}
