package com.indocyber.store.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;

    private String productName;

    private Double price;

    private String currency;

    private Integer discount;

    private String dimension;

    private String unit;
}
