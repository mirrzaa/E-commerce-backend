package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Integer price;

    @ManyToMany(mappedBy = "products")
    private Collection<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "Category",
            joinColumns = @JoinColumn(
                    name = "productId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "orderId", referencedColumnName = "id"))
    private Collection<Order> orders;

    public Product(Long id, String name, String description, Long categoryId, Integer price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Long getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }

    public Integer getPrice(){
        return price;
    }

    public void setPrice(Integer price){
        this.price = price;
    }
}
