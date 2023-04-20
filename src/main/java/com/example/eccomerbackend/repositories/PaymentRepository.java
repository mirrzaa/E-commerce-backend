package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
