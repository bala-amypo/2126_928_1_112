package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;

@Service
public class VerificationRuleService {

    private VerificationRuleRepository repo;

    public VerificationRuleService(VerificationRuleRepository repo) {
        this.repo = repo;
    }

    public VerificationRule createRule(VerificationRule rule) {
        return repo.save(rule);
    }

    public List<VerificationRule> getAllRules() {
        return repo.findAll();
    }
}
