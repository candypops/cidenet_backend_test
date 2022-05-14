package com.cidenet.cidenet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean status;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "second_last_name")
    private String  secondLastName;

    @Column(name = "employee_id",nullable = false)
    private String employeeId;

    @Column(name = "creation_date",nullable = false)
    private Date creationDate;

    @Column(name = "modification_date")
    private Date modificationDate;

}
