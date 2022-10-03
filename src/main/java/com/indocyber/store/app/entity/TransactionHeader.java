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

    private String documentCode;

    private String documentNumber;

    private String user;

    private Integer total;

    private LocalDate date;

    @ManyToOne
    private Login login;
}
