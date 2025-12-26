// // VerificationRuleRepository
// package com.example.demo.repository;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.VerificationRule;

// public interface VerificationRuleRepository
//         extends JpaRepository<VerificationRule, Long> {

//     List<VerificationRule> findByActiveTrue();
// }
package com.example.demo.repository;

import com.example.demo.entity.VerificationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VerificationRuleRepository extends JpaRepository<VerificationRule, Long> {
    List<VerificationRule> findByActiveTrue(); // Required for t61, t62 [cite: 173, 186]
}