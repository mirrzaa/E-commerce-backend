package com.example.eccomerbackend.controllers;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.eccomerbackend.models.entities.Category;
import com.example.eccomerbackend.repositories.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class CategoryController {
}