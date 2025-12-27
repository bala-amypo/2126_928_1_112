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
import lombok.*;

@Entity
@Getter // Replaces @Data to avoid equals() collision on empty objects
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;
    
    private Boolean active;
}