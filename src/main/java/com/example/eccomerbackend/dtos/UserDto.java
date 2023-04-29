package com.example.eccomerbackend.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserDto { // TODO: create user dto fields and validate them using validation annotations
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "firstname should have at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 2, message = "lastname should have at least 2 characters")
    private String lastName;
    @NotEmpty
    @Size(min = 2, message = "username should have at least 2 characters")
    private String username;
    @NotEmpty
    @Size(min = 8, max = 25, message = "password should have at least 8 characters")
    private String password;
    @NotEmpty
    private LocalDate birthDate;
    private String phoneNumber;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String postAddress;
    public UserDto(){

    }

    public UserDto(String firstName, String lastName, String username, String password, LocalDate birthDate, String phoneNumber, String email, String postAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.postAddress = postAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
