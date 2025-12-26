// package com.example.demo.service;

// import com.example.demo.entity.VerificationRule;

// public interface VerificationRuleService {

//     VerificationRule createRule(VerificationRule rule);
// }
package com.example.demo.service;

import com.example.demo.entity.VerificationRule;
import java.util.List;

public interface VerificationRuleService {
    VerificationRule createRule(VerificationRule rule);
    // Required for the verification logic
    List<VerificationRule> getActiveRules();
}