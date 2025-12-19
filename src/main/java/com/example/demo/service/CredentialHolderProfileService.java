package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;

@Service
public class CredentialHolderProfileService {

    private CredentialHolderProfileRepository repo;

    public CredentialHolderProfileService(CredentialHolderProfileRepository repo) {
        this.repo = repo;
    }

    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        return repo.save(profile);
    }

    public List<CredentialHolderProfile> getAllHolders() {
        return repo.findAll();
    }
}
