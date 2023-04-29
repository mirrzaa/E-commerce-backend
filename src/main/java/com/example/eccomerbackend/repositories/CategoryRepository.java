package com.example.eccomerbackend.repositories;

import java.util.List;

import com.example.eccomerbackend.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
