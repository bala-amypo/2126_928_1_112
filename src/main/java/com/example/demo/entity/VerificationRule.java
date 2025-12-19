// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class VerificationRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String ruleCode;
//     private String description;
//     private String appliesToType;
//     private String validationExpression;
//     private boolean active;

//     public VerificationRule() {
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getRuleCode() {
//         return ruleCode;
//     }

//     public void setRuleCode(String ruleCode) {
//         this.ruleCode = ruleCode;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getAppliesToType() {
//         return appliesToType;
//     }

//     public void setAppliesToType(String appliesToType) {
//         this.appliesToType = appliesToType;
//     }

//     public String getValidationExpression() {
//         return validationExpression;
//     }

//     public void setValidationExpression(String validationExpression) {
//         this.validationExpression = validationExpression;
//     }

//     public boolean isActive() {
//         return active;
//     }

//     public void setActive(boolean active) {
//         this.active = active;
//     }
// }
