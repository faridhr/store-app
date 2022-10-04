package com.indocyber.store.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
public class TransactionHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3)
    private String documentCode;

    @Column(length = 10)
    private String documentNumber;

    @Column(length = 50)
    private String userLogin;

    private Integer total;

    @Column(length = 10)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Login login;
}
