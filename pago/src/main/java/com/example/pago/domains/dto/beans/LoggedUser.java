package com.example.pago.domains.dto.beans;

import com.example.pago.domains.enums.Role;

public class LoggedUser {
    private Long id;
    private String firstName;
    private String nickName;
    private String email;
    private Role role;

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public LoggedUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public LoggedUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public LoggedUser setRole(Role role) {
        this.role = role;
        return this;
    }

    public boolean exists() {
        return this.id != null;
    }

    public void delete() {
        this.id = null;
        this.firstName = null;
        this.nickName = null;
        this.email = null;
        this.role = null;
    }

    public boolean hasAdminRights() {
        return this.getRole().equals(Role.ADMIN)
                || this.getRole().equals(Role.SUPER_ADMIN);
    }
}
