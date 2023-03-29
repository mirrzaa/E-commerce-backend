package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ROLE_USER;
    private String ROLE_ADMIN;
    private String ROLE_SELLER;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getROLE_USER() {
        return ROLE_USER;
    }

    public void setROLE_USER(String ROLE_USER) {
        this.ROLE_USER = ROLE_USER;
    }

    public String getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public void setROLE_ADMIN(String ROLE_ADMIN) {
        this.ROLE_ADMIN = ROLE_ADMIN;
    }

    public String getROLE_SELLER() {
        return ROLE_SELLER;
    }

    public void setROLE_SELLER(String ROLE_SELLER) {
        this.ROLE_SELLER = ROLE_SELLER;
    }
}
