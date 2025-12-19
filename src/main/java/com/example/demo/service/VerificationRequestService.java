package com.example.demo.service;

public interface VerificationRequestService {

    /**
     * Process a verification request
     * @param requestId ID of the verification request
     * @return result message
     */
    String processRequest(Long requestId);
}
