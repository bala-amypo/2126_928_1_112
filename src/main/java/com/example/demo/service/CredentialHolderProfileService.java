package com.example.demo.service;

import com.example.demo.entity.CredentialHolderProfile;
import java.util.List;

public interface CredentialHolderProfileService {

    CredentialHolderProfile createProfile(CredentialHolderProfile profile);

    List<CredentialHolderProfile> getAllProfiles();

    CredentialHolderProfile getProfileById(Long id);
}
