package com.example.eccomerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.eccomerbackend.models.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
