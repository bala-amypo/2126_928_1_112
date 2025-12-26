// package com.example.demo.dto;

// public class JwtResponse {

//     private String token;
//     private String email;
//     private String role;

//     public JwtResponse(String token, String email, String role) {
//         this.token = token;
//         this.email = email;
//         this.role = role;
//     }

//     public String getToken() { return token; }
//     public String getEmail() { return email; }
//     public String getRole() { return role; }
// }
package com.example.demo.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor // <--- Fixes "constructor cannot be applied" error
public class JwtResponse {
    private String token;
}