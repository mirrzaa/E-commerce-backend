package com.example.eccomerbackend.services.impl;

import com.example.eccomerbackend.models.entities.Product;
import com.example.eccomerbackend.repositories.ProductRepository;
import com.example.eccomerbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }
}