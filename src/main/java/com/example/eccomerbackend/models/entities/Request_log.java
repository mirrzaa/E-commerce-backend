package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;

import java.util.*;
@Entity
@Table(name = "request_log")
public class Request_log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created_date;

    @OneToOne()
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Request_log(Long id, Date created_date, Payment payment) {
        this.id = id;
        this.created_date = created_date;
        this.payment = payment;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getCreated_date(){
        return created_date;
    }

    public void setCreated_date(Date created_date){
        this.created_date = created_date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
