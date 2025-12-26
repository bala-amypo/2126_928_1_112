// // AuditTrailRecordRepository
// package com.example.demo.repository;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.AuditTrailRecord;

// public interface AuditTrailRecordRepository
//         extends JpaRepository<AuditTrailRecord, Long> {

//     List<AuditTrailRecord> findByCredentialId(Long credentialId);
// }
package com.example.demo.repository;

import com.example.demo.entity.AuditTrailRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditTrailRecordRepository extends JpaRepository<AuditTrailRecord, Long> {
    List<AuditTrailRecordRepository> findByCredentialId(Long credentialId); // Required for t64 [cite: 178, 186]
}