package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final List<CredentialRecord> credentials = new ArrayList<>();

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        credentials.add(record);
        return record;
    }

    @Override
    public List<CredentialRecord> getAllCredentials() {
        return new ArrayList<>(credentials);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return credentials.stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public boolean credentialExists(Long credentialId) {
        return credentials.stream().anyMatch(c -> c.getId().equals(credentialId));
    }
}
