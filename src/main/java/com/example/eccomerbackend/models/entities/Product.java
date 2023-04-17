package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "products")
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
}
