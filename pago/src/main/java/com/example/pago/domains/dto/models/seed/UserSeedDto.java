package com.example.pago.domains.dto.models.seed;

import com.example.pago.domains.dto.models.BaseEntityDto;
import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserSeedDto extends BaseEntityDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String nickName;
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private Long town;
    @Expose
    private String dateOfBirth;
    @Expose
    private Integer age;
    @Expose
    private String gender;
    @Expose
    private String avatar;
    @Expose
    private String role;

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public UserSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotBlank
    public String getNickName() {
        return nickName;
    }

    public UserSeedDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public UserSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    @Length(min = 8)
    public String getPassword() {
        return password;
    }

    public UserSeedDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getTown() {
        return town;
    }

    public UserSeedDto setTown(Long town) {
        this.town = town;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UserSeedDto setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserSeedDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserSeedDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserSeedDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserSeedDto setRole(String role) {
        this.role = role;
        return this;
    }
}
