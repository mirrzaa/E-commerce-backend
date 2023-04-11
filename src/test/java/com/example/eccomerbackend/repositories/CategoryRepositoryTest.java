package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveMethod(){
        Category category = new Category();
        category.setName("Category 1");

        Category savedObject = categoryRepository.save(category);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
}