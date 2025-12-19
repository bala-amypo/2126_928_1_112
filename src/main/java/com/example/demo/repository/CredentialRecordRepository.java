package com.example.demo.repository;
import java.util.Optional;
import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordRepository 
        extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findByExpiryDateBefore(LocalDate date);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    List<CredentialRecord> findByHolderId(Long holderId);
}
