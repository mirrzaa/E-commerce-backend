package com.example.eccomerbackend.services;

import com.example.eccomerbackend.models.entities.Product;
import java.util.List;

public interface ProductService {
    public abstract List<Product> findAll();
    public abstract void addProduct(Product product);
}
