package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestRepository 
        extends JpaRepository<VerificationRequest, Long> {
}
