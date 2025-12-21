package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord record);
    List<CredentialRecord> getAllCredentials();
    CredentialRecord getCredentialByCode(String code);
    boolean credentialExists(Long credentialId);
}
