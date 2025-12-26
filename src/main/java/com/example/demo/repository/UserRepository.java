// // UserRepository
// package com.example.demo.repository;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.User;

// public interface UserRepository extends JpaRepository<User, Long> {
//     boolean existsByEmail(String email);
//     Optional<User> findByEmail(String email);
// }
package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); // Required for t20, t49, t50 [cite: 149, 186]
    Optional<User> findByEmail(String email); // Required for t51, t52 [cite: 152, 186]
}