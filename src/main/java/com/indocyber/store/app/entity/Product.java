package com.indocyber.store.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 18)
    private String productCode;

    @Column(length = 30)
    private String productName;

    private Double price;

    @Column(length = 5)
    private String currency;

    private Integer discount;

    @Column(length = 5)
    private String unit;

    @Transient
    private Double discountPrice;

    @Column(length = 50)
    private String dimension;
}
