package com.example.pago.domains.dto.bindings;

import com.example.pago.domains.enums.Gender;
import com.example.pago.domains.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String town;
    private String avatarPath;
    private boolean hasAllOptional;

    @NotBlank()
    @Length(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank()
    @Length(min = 2)
    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotBlank()
    @Length(min = 4)
    public String getNickName() {
        return nickName;
    }

    public UserRegisterDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min = 8)
    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserRegisterDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public UserRegisterDto setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getTown() {
        return town;
    }

    public UserRegisterDto setTown(String town) {
        this.town = town;
        return this;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public UserRegisterDto setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
        return this;
    }

    public boolean hasAllOptional() {
        return (this.gender != null &&
                !this.gender.toUpperCase().equals(Gender.NONE.toString()))
            && this.dateOfBirth != null
            && this.town != null;
    }
}
