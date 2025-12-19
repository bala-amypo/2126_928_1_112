import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;

@Service
public class VerificationRequestService {

    private final VerificationRequestRepository repo;
    private final CredentialRecordService credService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;

    public VerificationRequestService(
            VerificationRequestRepository repo,
            CredentialRecordService credService,
            VerificationRuleService ruleService,
            AuditTrailService auditService) {
        this.repo = repo;
        this.credService = credService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        return repo.save(request);
    }

    public VerificationRequest processVerification(Long id) {

        VerificationRequest req = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Verification request not found"));

        // 🔹 Fetch credential ONCE and unwrap Optional
        CredentialRecord cr = credService
                .getCredentialByCode(req.getCredentialId())
                .orElseThrow(() -> new IllegalStateException("Credential not found"));

        // 🔹 Simple verification logic
        if (cr.getExpiryDate().isBefore(LocalDate.now())) {
            req.setStatus("FAILED");
        } else {
            req.setStatus("SUCCESS");
        }

        // 🔹 Audit log
        AuditTrailRecord log = new AuditTrailRecord();
        log.setCredentialId(req.getCredentialId());
        log.setEventType("VERIFICATION");
        log.setDetails(req.getStatus());

        auditService.logEvent(log);

        return repo.save(req);
    }
}
