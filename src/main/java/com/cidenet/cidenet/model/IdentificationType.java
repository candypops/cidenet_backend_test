package com.cidenet.cidenet.model;

import javax.persistence.*;

@Entity
@Table
public class IdentificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean status;
}
