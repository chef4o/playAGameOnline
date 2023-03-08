package com.example.pago.domains.dto.views;

import com.example.pago.domains.enums.Role;

public class UserAdminViewDto {
    private Long id;
    private String nickName;
    private String email;
    private String role;

    public UserAdminViewDto() {
    }

    public Long getId() {
        return id;
    }

    public UserAdminViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserAdminViewDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAdminViewDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserAdminViewDto setRole(String role) {
        this.role = role;
        return this;
    }

    public boolean hasAdminRights() {
        return this.getRole().toUpperCase().equals(String.valueOf(Role.ADMIN))
                || this.getRole().toUpperCase().equals(String.valueOf(Role.SUPER_ADMIN));
    }
}
