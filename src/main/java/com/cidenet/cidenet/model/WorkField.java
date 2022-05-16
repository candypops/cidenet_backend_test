package com.cidenet.cidenet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "work_field")
public class WorkField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    @JsonIgnore
    private String status;


    public WorkField() {
    }

    public WorkField(
            String name,
            String status) {
        this.name = name;
        this.status = status;
    }

    public WorkField(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
