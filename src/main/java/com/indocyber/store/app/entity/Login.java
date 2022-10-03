package com.indocyber.store.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    private String password;

}
