package com.example.daolayer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public final class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "phone_number")
    private String phone;
}
