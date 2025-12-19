package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    boolean credentialExists(Long credentialId);

    // Add these methods
    CredentialRecord createCredential(CredentialRecord record);
    List<CredentialRecord> getAllCredentials();
    CredentialRecord getCredentialByCode(String code);
}
