// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.AuditTrailRecord;

// public interface AuditTrailService {

//     AuditTrailRecord logEvent(AuditTrailRecord record);

//     List<AuditTrailRecord> getLogsByCredential(Long credentialId);
// }
package com.example.demo.service;

import com.example.demo.entity.AuditTrailRecord;
import java.util.List;

public interface AuditTrailService {
    AuditTrailRecord logEvent(AuditTrailRecord record);
    List<AuditTrailRecord> getLogsByCredential(Long credentialId);
}