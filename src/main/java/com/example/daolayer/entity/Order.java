package com.example.daolayer.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public final class Order {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "product_name")
    private String product;
    private int amount;
}
