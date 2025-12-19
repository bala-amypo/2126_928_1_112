package com.example.demo.service.impl;

import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    @Override
    public boolean applyRules(Long requestId) {
        // Example rule: approve if ID is even
        return requestId != null && requestId % 2 == 0;
    }
}
