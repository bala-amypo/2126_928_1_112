// package com.example.demo.security;

// import org.springframework.stereotype.Component;

// @Component
// public class JwtUtil {

//     public String generateToken(Long userId, String email, String role) {
//         return email + "_" + role + "_TOKEN";
//     }
// }
package com.example.demo.security;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    // Methods mocked in test, implementation details stubbed
    public String generateToken(Long userId, String email, String role) {
        return "mock-token";
    }
}