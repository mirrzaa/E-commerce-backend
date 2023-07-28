package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname", nullable = true)
    private String firstName;
    @Column(name = "lastname", nullable = true)
    private String lastName;
    @Column(name = "username", nullable = true)
    private String username;
    @Column(name = "password", nullable = true)
    private String password;
    @Column(name = "birth_day", nullable = true)
    private LocalDate birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "post_address", nullable = true)
    private String postAddress;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserStatus userStatus;
    public User(){

    }
    public User(Long id, String username, String password, String email, Collection<? extends GrantedAuthority> getAuthorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.getAuthorities = getAuthorities;
    }

    @Transient
    private Collection<? extends GrantedAuthority> getAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
