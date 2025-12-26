// package com.example.demo.entity;

// import java.time.LocalDateTime;
// import jakarta.persistence.*;

// @Entity
// public class AuditTrailRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long credentialId;
//     private LocalDateTime loggedAt;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getCredentialId() { return credentialId; }
//     public void setCredentialId(Long credentialId) { this.credentialId = credentialId; }

//     public LocalDateTime getLoggedAt() { return loggedAt; }
//     public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class AuditTrailRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long credentialId;
    private LocalDateTime loggedAt; // Ensure this exact name
}