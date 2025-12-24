package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF (for REST APIs)
            .csrf(csrf -> csrf.disable())

            // Allow all requests (API-only application)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // Disable default Spring Security login page
            .formLogin(form -> form.disable())

            // Disable HTTP Basic authentication
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
