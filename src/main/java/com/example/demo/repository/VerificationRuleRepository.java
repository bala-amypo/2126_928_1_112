package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VerificationRule;

public interface VerificationRuleRepository 
        extends JpaRepository<VerificationRule, Long> {
}
