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

    private String documentCode;

    private String documentNumber;

    private String productCode;

    private Double price;

    private Integer qty;

    private String unit;

    private Double subTotal;

    private String currency;

}
