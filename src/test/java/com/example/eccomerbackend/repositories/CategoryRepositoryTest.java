package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.Category;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testSaveCategory(){
        Category category = new Category();
        category.setName("Category 1");

        Category savedObject = categoryRepository.save(category);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void testUpdateUsingSaveMethod(){
        Long id = 1L;
        Category category = categoryRepository.findById(id).get();

        category.setName("updated category 1");

        categoryRepository.save(category);
    }

    @Test
    void testFindByIdMethod(){
        Long id = 1L;

        Category category = categoryRepository.findById(id).get();
    }

    @Test
    void testSaveAllMethod(){
        Category category2 = new Category();
        category2.setName("Category 2");

        Category category3 = new Category();
        category3.setName("Category 3");

        categoryRepository.saveAll(List.of(category2, category3));
    }

    @Test
    void testFindAllMethod(){
        List<Category> categories = categoryRepository.findAll();

        categories.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void testDeleteByIdMethod(){
        Long id = 1L;
        categoryRepository.deleteById(id);
    }

    @Test
    void testDeleteMethod(){
        Long id = 2L;
        Category category = categoryRepository.findById(id).get();

        categoryRepository.delete(category);
    }

    @Test
    void testDeleteAllMethod(){
        categoryRepository.deleteAll();
    }

    @Test
    void testCountMethod(){
        long count = categoryRepository.count();

        System.out.println(count);
    }

    @Test
    void testExistsByIdMethod(){
        Long id = 1L;

        boolean result = categoryRepository.existsById(id);

        System.out.println(result);
    }
}