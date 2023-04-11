package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@RequiredArgsConstructor
@Entity
@ToString
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Product",
        joinColumns = @JoinColumn(
                name = "categoryId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "productId", referencedColumnName = "id"))
    private Collection<Product> products;

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}


