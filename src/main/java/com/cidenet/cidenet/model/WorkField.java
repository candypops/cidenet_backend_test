package com.cidenet.cidenet.model;
import javax.persistence.*;

@Entity
@Table
public class WorkField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    public WorkField() {
    }

    public WorkField(
            String name
    ) {
        this.name = name;
    }

}
