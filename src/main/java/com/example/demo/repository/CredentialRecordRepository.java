// CredentialRecordRepository
package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findByHolderId(Long holderId);
    Optional<CredentialRecord> findByCredentialCode(String code);
}
