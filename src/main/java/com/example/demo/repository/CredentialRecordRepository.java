package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    // ✅ This now matches the entity field exactly
    List<CredentialRecord> findByHolderId(Long holderId);
}
