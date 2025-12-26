// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//             // Disable CSRF (for REST APIs)
//             .csrf(csrf -> csrf.disable())

//             // Allow all requests (API-only application)
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll()
//             )

//             // Disable default Spring Security login page
//             .formLogin(form -> form.disable())

//             // Disable HTTP Basic authentication
//             .httpBasic(basic -> basic.disable());

//         return http.build();
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