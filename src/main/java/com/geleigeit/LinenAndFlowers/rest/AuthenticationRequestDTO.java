package com.geleigeit.LinenAndFlowers.rest;

public class AuthenticationRequestDTO {

    private String email;
    private String password;

    public AuthenticationRequestDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
