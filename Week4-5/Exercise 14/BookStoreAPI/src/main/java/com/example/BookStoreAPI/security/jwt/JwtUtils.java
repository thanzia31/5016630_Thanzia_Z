package com.example.BookStoreAPI.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "yourSecretKey"; // Use a secure secret key here
    private final int jwtExpirationMs = 864000000; // Token validity in milliseconds (24 hours)

    public String generateJwtToken(Authentication authentication) {
        // Get the principal name from the authenticated user
        String email = authentication.getName();

        // Build the JWT token
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Method to validate token, parse claims, etc.
}
