// // CredentialHolderProfileRepository
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.CredentialHolderProfile;

// public interface CredentialHolderProfileRepository
//         extends JpaRepository<CredentialHolderProfile, Long> {}
package com.example.demo.repository;

import com.example.demo.entity.CredentialHolderProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialHolderProfileRepository extends JpaRepository<CredentialHolderProfile, Long> {
    // Standard JpaRepository methods (save, findById) satisfy t09-t12 [cite: 186]
}