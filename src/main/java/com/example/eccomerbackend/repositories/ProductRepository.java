package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
