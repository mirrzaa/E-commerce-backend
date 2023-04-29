package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
}
