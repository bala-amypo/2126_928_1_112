// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.VerificationRequest;
// import com.example.demo.service.VerificationRequestService;

// @RestController
// public class VerificationRequestController {

//     private VerificationRequestService service;

//     public VerificationRequestController(VerificationRequestService service) {
//         this.service = service;
//     }

//     @PostMapping("/api/verification")
//     public VerificationRequest create(@RequestBody VerificationRequest req) {
//         return service.initiateVerification(req);
//     }

//     @PutMapping("/api/verification/{id}/process")
//     public VerificationRequest process(@PathVariable Long id) {
//         return service.processVerification(id);
//     }
// }
