package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
