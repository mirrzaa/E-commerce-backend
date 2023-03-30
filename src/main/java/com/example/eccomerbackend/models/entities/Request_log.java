package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;

import java.util.*;

public class Request_log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Date created_date;
    private Long payment_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    public Request_log(Long id, Date created_date, Long payment_id){
        this.id = id;
        this.created_date = created_date;
        this.payment_id = payment_id;
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

    public Long getPayment_id(){
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
}
