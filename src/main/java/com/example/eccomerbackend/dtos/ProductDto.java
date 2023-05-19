package com.example.eccomerbackend.dtos;

import jakarta.validation.constraints.*;

public class ProductDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Product name should have at least 2 characters")
    private String name;

    @Size(max = 255, message = "Product name should not be more than 255 characters")
    private String description;

    @NotNull
    private Float price;

    public ProductDto(Long id, String name, String description, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
