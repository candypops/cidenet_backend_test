package com.cidenet.cidenet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Entity
@Table(name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")
        })
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 300)
    private String email;

    @Column(name = "status", nullable = false)
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

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "modification_date")
    private Date modificationDate;

    @ManyToOne
    @JoinColumn(name = "identification_type_fk", nullable = false)
    private IdentificationType identificationType;

    @ManyToOne
    @JoinColumn(name = "country_fk", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "work_field_fk", nullable = false)
    private WorkField workField;


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
        this.email = email.toUpperCase(Locale.ROOT);
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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
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

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public WorkField getWorkField() {
        return workField;
    }

    public void setWorkField(WorkField workField) {
        this.workField = workField;
    }

    public Employee(Long id, String email, String status, String firstName, String middleName,
                    String lastName, String secondLastName, String employeeId, Date creationDate,
                    Date modificationDate, IdentificationType identificationType,
                    Country country, WorkField workField) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.identificationNumber = employeeId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.identificationType = identificationType;
        this.country = country;
        this.workField = workField;
    }

    public Employee(String email, String status, String firstName, String middleName, String lastName, String secondLastName, String employeeId, Date creationDate,
                    Date modificationDate, IdentificationType identificationType, Country country, WorkField workField) {
        this.email = email;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.identificationNumber = employeeId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.identificationType = identificationType;
        this.country = country;
        this.workField = workField;
    }

    public Employee(String email, String status, String firstName, String middleName, String lastName, String secondLastName, String employeeId, Date creationDate,
                    Date modificationDate) {
        this.email = email;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.identificationNumber = employeeId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

}
