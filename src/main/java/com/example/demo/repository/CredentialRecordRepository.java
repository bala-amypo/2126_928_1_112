// // CredentialRecordRepository
// package com.example.demo.repository;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.CredentialRecord;

// public interface CredentialRecordRepository
//         extends JpaRepository<CredentialRecord, Long> {

//     List<CredentialRecord> findByHolderId(Long holderId);
//     Optional<CredentialRecord> findByCredentialCode(String code);
// }
package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {
    List<CredentialRecord> findByHolderId(Long holderId);
    Optional<CredentialRecord> findByCredentialCode(String credentialCode);
    
    @Query("SELECT c FROM CredentialRecord c WHERE c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(@Param("date") LocalDate date);

    // HQL Requirement for Test 57
    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(@Param("status") String status);

    // HQL Requirement for Test 59
    @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
    List<CredentialRecord> searchByIssuerAndType(@Param("issuer") String issuer, @Param("type") String type);
}