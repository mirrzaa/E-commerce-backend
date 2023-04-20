package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable= true)
    private String firstName;
    @Column(name = "last_name", nullable= true)
    private String lastName;
    @Column(name = "user_name", nullable= true)
    private String username;
    @Column(name = "password", nullable= true)
    private String password;
    @Column(name = "birth_day", nullable= true)
    private LocalDate birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email", nullable= true)
    private String email;
    @Column(name = "post_address", nullable= true)
    private String postAddress;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserStatus userStatus;
}
