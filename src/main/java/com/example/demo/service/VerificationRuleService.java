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
    [cite_start]// [cite: 174] Required to fetch active rules in verification process
    List<VerificationRule> getActiveRules();
}