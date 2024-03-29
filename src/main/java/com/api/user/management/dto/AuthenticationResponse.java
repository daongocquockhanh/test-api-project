package com.api.user.management.dto;

public class AuthenticationResponse {
    private final String jwt;
    private final Long userId;
    private final String role;

    public AuthenticationResponse(String jwt, Long userId, String role) {
        this.jwt = jwt;
        this.userId = userId;
        this.role = role;
    }

    // Getters
    public String getJwt() {
        return jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
