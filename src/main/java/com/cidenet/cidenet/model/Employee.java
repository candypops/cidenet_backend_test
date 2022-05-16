package com.cidenet.cidenet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee",
uniqueConstraints = {
        @UniqueConstraint(name = "employee_id_unique", columnNames = "employee_id" ),
        @UniqueConstraint(name = "email_unique", columnNames = "email")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "status",nullable = false)
    @JsonIgnore
    private String status;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "second_last_name", nullable = false, length = 20)
    private String secondLastName;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "modification_date")
    private Date modificationDate;

    public Employee() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }


    public Employee(Long id, String email, String status, String firstName, String middleName, String lastName, String secondLastName, String employeeId, Date creationDate, Date modificationDate) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.employeeId = employeeId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Employee(String email, String status, String firstName, String middleName, String lastName, String secondLastName, String employeeId, Date creationDate, Date modificationDate) {
        this.email = email;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.employeeId = employeeId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }
}
