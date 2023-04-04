package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;
import java.util.Collection;
import java.util.*;

@Data
=======
import lombok.RequiredArgsConstructor;

import java.util.Date;
>>>>>>> 0644590c3bde997f71e93d3732f9d542cb8f9550
@RequiredArgsConstructor
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Date creationDate;
    private Date updatedDate;
    private Long product_id;
    private Long payment_id;

    @OneToOne(mappedBy = "orders")
    private Collection<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id"))
    private Payment payment;

    public Order(Long id, Long userId, Date creationDate, Date updatedDate, Long product_id, Long payment_id){
        this.id = id;
        this.userId = userId;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
        this.product_id = product_id;
        this.payment_id = payment_id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate(){
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate){
        this.updatedDate = updatedDate;
    }

    public Long getProductId(){
        return product_id;
    }

    public void setProductId(Long product_id){
        this.product_id = product_id;
    }

    public Long getPaymentId(){
        return payment_id;
    }

    public void setPaymentId(Long payment_id){
        this.payment_id = payment_id;
    }
}
