package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class AuditTrailRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;
    private String eventType;
    private String details;
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public AuditTrailRecord() {
    }

    public Long getId() {
        return id;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
