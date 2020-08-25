package com.geleigeit.LinenAndFlowers.controller;

public class AuthenticationRequestDTO {

    private final String email;
    private final String password;

    public AuthenticationRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
