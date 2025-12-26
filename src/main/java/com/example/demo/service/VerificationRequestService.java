// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.VerificationRequest;

// public interface VerificationRequestService {

//     VerificationRequest initiateVerification(VerificationRequest request);

//     VerificationRequest processVerification(Long requestId);

//     List<VerificationRequest> getRequestsByCredential(Long credentialId);
// }
package com.example.demo.service;

import com.example.demo.entity.VerificationRequest;
import java.util.List;

public interface VerificationRequestService {
    VerificationRequest initiateVerification(VerificationRequest request);
    VerificationRequest processVerification(Long requestId);
    List<VerificationRequest> getRequestsByCredential(Long credentialId);
}