package com.cidenet.cidenet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class IdentificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonIgnore
    private String status;

    @OneToMany(mappedBy = "identificationType")
    @JsonIgnore
    private List<Employee> employee;


    public IdentificationType() {
    }

    public IdentificationType(String name, String status, List<Employee> employee) {
        this.name = name;
        this.status = status;
        this.employee = employee;
    }

    public IdentificationType(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}
