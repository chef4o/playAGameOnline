package com.example.pago.domains.entities;

import com.example.pago.domains.enums.Gender;

import com.example.pago.domains.enums.Role;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private Town town;
    private LocalDate dateOfBirth;
    private Integer age;
    private Gender gender;
    private Avatar avatar;
    private Role role;

    public User() {
    }

    @Column(name="first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "nickname", nullable = false, unique = true)
    public String getNickName() {
        return nickName;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    @Column(name = "dob")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    @OneToOne
    public Avatar getAvatar() {
        return avatar;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    public Role getRole() {
        return role;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    public User setTown(Town town) {
        this.town = town;
        return this;
    }
    public User setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    public User setAvatar(Avatar avatar) {
        this.avatar = avatar;
        return this;
    }
    public User setRole(Role role) {
        this.role = role;
        return this;
    }
}
