package com.example.eccomerbackend.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
public class User {
    private Long id;
    private String firtsName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String postAddress;

}
