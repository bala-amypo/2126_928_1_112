// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.AuditTrailRecord;
// import com.example.demo.service.AuditTrailService;

// @RestController
// @RequestMapping("/audit")
// public class AuditTrailController {

//     private final AuditTrailService service;

//     public AuditTrailController(AuditTrailService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<AuditTrailRecord> log(
//             @RequestBody AuditTrailRecord record) {
//         return ResponseEntity.ok(service.logEvent(record));
//     }

//     @GetMapping("/{credentialId}")
//     public ResponseEntity<List<AuditTrailRecord>> getByCredential(
//             @PathVariable Long credentialId) {
//         return ResponseEntity.ok(service.getLogsByCredential(credentialId));
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditTrailController {
    private final AuditTrailService auditTrailService;

    public AuditTrailController(AuditTrailService auditTrailService) {
        this.auditTrailService = auditTrailService;
    }

    @PostMapping
    public ResponseEntity<AuditTrailRecord> log(@RequestBody AuditTrailRecord record) {
        return ResponseEntity.ok(auditTrailService.logEvent(record)); // [cite: 204, 61]
    }

    @GetMapping("/credential/{credentialId}")
    public ResponseEntity<List<AuditTrailRecord>> getByCredential(@PathVariable Long credentialId) {
        return ResponseEntity.ok(auditTrailService.getLogsByCredential(credentialId)); // [cite: 178, 204, 138]
    }
}