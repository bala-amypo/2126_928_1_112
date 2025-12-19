package com.example.demo.service;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {

    private final CredentialHolderProfileRepository repository;

    public CredentialHolderProfileServiceImpl(CredentialHolderProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<CredentialHolderProfile> getAllHolders() {
        return repository.findAll();
    }
}
