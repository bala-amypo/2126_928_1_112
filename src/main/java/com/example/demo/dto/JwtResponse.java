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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor // This specifically fixes the AuthController errors
public class JwtResponse {
    private String token;
}