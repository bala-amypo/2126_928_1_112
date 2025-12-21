package com.example.demo.service;

import com.example.demo.entity.CredentialHolderProfile;
import java.util.List;

public interface CredentialHolderProfileService {
    CredentialHolderProfile createHolder(CredentialHolderProfile profile);
    List<CredentialHolderProfile> getAllHolders();
}
