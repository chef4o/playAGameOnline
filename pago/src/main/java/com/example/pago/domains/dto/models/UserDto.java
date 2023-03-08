package com.example.pago.domains.dto.models;

import com.example.pago.domains.entities.Town;
import com.example.pago.domains.enums.Gender;
import com.example.pago.domains.enums.Role;

import java.time.LocalDate;

public class UserDto  {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private Town town;
    private LocalDate dateOfBirth;
    private Integer age;
    private Gender gender;
    private String avatarPath;
    private Role role;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public UserDto setTown(Town town) {
        this.town = town;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public UserDto setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public UserDto setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserDto setRole(Role role) {
        this.role = role;
        return this;
    }

    public boolean exists() {
        return this.getId() != null;
    }

}
