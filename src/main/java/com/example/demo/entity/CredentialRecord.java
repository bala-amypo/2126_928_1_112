// package com.example.demo.entity;

// import java.time.LocalDate;
// import jakarta.persistence.*;

// @Entity
// public class CredentialRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long holderId;
//     private String credentialCode;
//     private String title;
//     private String issuer;
//     private String credentialType;
//     private String status;
//     private LocalDate expiryDate;
//     private String metadataJson;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getHolderId() { return holderId; }
//     public void setHolderId(Long holderId) { this.holderId = holderId; }

//     public String getCredentialCode() { return credentialCode; }
//     public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }

//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }

//     public String getIssuer() { return issuer; }
//     public void setIssuer(String issuer) { this.issuer = issuer; }

//     public String getCredentialType() { return credentialType; }
//     public void setCredentialType(String credentialType) { this.credentialType = credentialType; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }

//     public LocalDate getExpiryDate() { return expiryDate; }
//     public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

//     public String getMetadataJson() { return metadataJson; }
//     public void setMetadataJson(String metadataJson) { this.metadataJson = metadataJson; }
// }


package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credential_record")
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String issuer;
    private String type;
    private String status;

    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    // Relationship to the Holder Profile
    @ManyToOne
    @JoinColumn(name = "holder_id")
    private CredentialHolderProfile holder;

    // Relationship to Verification Rules
    // This is where the list of rules is stored
    @OneToMany(mappedBy = "credentialRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VerificationRule> verificationRules = new ArrayList<>();

    // --- Constructors ---

    public CredentialRecord() {
        this.status = "ACTIVE"; // Default status
        this.verificationRules = new ArrayList<>();
    }

    // --- THE FIX IS IN THIS METHOD ---

    public void addVerificationRule(VerificationRule rule) {
        // FIX: Check if list is null, but DO NOT overwrite it if it already exists
        if (this.verificationRules == null) {
            this.verificationRules = new ArrayList<>();
        }
        
        // Append to the existing list (fixing the t42_multipleRules failure)
        this.verificationRules.add(rule);
        
        // Set the back-reference (assuming VerificationRule has this setter)
        rule.setCredentialRecord(this);
    }

    public void removeVerificationRule(VerificationRule rule) {
        if (this.verificationRules != null) {
            this.verificationRules.remove(rule);
            rule.setCredentialRecord(null);
        }
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public CredentialHolderProfile getHolder() {
        return holder;
    }

    public void setHolder(CredentialHolderProfile holder) {
        this.holder = holder;
    }

    public List<VerificationRule> getVerificationRules() {
        return verificationRules;
    }

    public void setVerificationRules(List<VerificationRule> verificationRules) {
        this.verificationRules = verificationRules;
    }
}