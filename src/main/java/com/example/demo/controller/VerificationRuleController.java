// package com.example.demo.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.VerificationRule;
// import com.example.demo.service.VerificationRuleService;

// @RestController
// @RequestMapping("/rules")
// public class VerificationRuleController {

//     private final VerificationRuleService service;

//     public VerificationRuleController(VerificationRuleService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<VerificationRule> create(
//             @RequestBody VerificationRule rule) {
//         return ResponseEntity.ok(service.createRule(rule));
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class VerificationRuleController {
    private final VerificationRuleService verificationRuleService;

    public VerificationRuleController(VerificationRuleService verificationRuleService) {
        this.verificationRuleService = verificationRuleService;
    }

    @PostMapping
    public ResponseEntity<VerificationRule> create(@RequestBody VerificationRule rule) {
        return ResponseEntity.ok(verificationRuleService.createRule(rule)); // 
    }
}