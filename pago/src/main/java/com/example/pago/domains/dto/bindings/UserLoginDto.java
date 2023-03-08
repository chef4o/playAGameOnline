package com.example.pago.domains.dto.bindings;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    private String email;
    private String password;

    @Email
    public String getEmail() {
        return email;
    }

    public UserLoginDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    @Size(min = 8)
    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
