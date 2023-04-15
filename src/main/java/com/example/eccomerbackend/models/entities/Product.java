package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@Entity
//@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToOne(mappedBy = "products")
    private Order orders;

    public Product(Long id, String name, String description, Category category, Integer price) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }
}
