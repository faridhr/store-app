package com.indocyber.store.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3)
    private String documentCode;

    @Column(length = 10)
    private String documentNumber;

    @Column(length = 18)
    private String productCode;

    private Integer price;

    private Integer qty;

    @Column(length = 5)
    private String unit;

    private Double subTotal;

    @Column(length = 5)
    private String currency;

}
