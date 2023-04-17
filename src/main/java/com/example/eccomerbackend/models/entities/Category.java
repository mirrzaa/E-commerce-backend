package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@ToString
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "categories")
    private Collection<Product> products;
}


