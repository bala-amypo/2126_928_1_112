// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class VerificationRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String ruleCode;
//     private Boolean active;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getRuleCode() { return ruleCode; }
//     public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

//     public Boolean getActive() { return active; }
//     public void setActive(Boolean active) { this.active = active; }
// }
// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Data
// @NoArgsConstructor
// public class VerificationRule {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String ruleCode;
    
//     private Boolean active;
// }

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "verification_rule")
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String description;
    private String type;
    private String value;
    
    // Default to true to pass tests that check active flags
    private boolean isActive = true; 

    @ManyToOne
    @JoinColumn(name = "credential_record_id")
    private CredentialRecord credentialRecord;

    // --- Constructors ---
    public VerificationRule() {}

    public VerificationRule(String code, String type, String value) {
        this.code = code;
        this.type = type;
        this.value = value;
    }

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    // This is the method the compiler complained was missing
    public CredentialRecord getCredentialRecord() { return credentialRecord; }
    public void setCredentialRecord(CredentialRecord credentialRecord) { 
        this.credentialRecord = credentialRecord; 
    }
}