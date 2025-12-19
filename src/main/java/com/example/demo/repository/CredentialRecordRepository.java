package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findExpiredBefore(LocalDate date);

    @Query("select c from CredentialRecord c where c.status = ?1")
    List<CredentialRecord> findByStatusUsingHql(String status);

    @Query("select c from CredentialRecord c where c.issuer = ?1 and c.credentialType = ?2")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);

    List<CredentialRecord> findByHolderId(Long holderId);

    CredentialRecord findByCredentialCode(String code);
}
