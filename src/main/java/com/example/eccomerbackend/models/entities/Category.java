package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(name = "categories_seq",
                       allocationSize=1)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "category_name",
            unique = true
    )
    private String name;

    @OneToMany(mappedBy = "categories")
    private Collection<Product> products;
    
}


