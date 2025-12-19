package com.example.demo.service.impl;

import com.example.demo.service.CredentialRecordService;
import org.springframework.stereotype.Service;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    @Override
    public boolean credentialExists(Long credentialId) {
        // Example logic: valid if > 0
        return credentialId != null && credentialId > 0;
    }
}
