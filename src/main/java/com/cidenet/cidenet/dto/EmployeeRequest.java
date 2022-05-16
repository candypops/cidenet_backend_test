package com.cidenet.cidenet.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Locale;

public class EmployeeRequest {

    @NotEmpty(message = "Primer nombre no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Primer nombre invalido")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Segundo nombre invalido")
    private String middleName;

    @NotEmpty(message = "Primer apellido no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Primer apellido invalido")
    private String lastName;

    @NotEmpty(message = "Segundo apellido no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Segundo apellido invalido")
    private String secondLastName;

    @NotEmpty(message = "Numero de empleado no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Numero de empleado invalido")
    private String identificationNumber;

    @NotNull(message = "Codigo tipo de identificacion no puede estar vacio")
    @Min(value = 1, message = "Codigo tipo de identificacion no puede estar vacio")
    private  int identificationTypeCode;

    @NotNull(message = "Codigo pais no puede estar vacio")
    @Min(value = 1, message = "Codigo pais no puede estar vacio")
    private  int countryCode;

    @NotNull(message = "Codigo area de trabajo no puede estar vacio")
    @Min(value = 1, message = "Codigo area de trabajo no puede estar vacio")
    private int workFieldCode;

    public EmployeeRequest(){

    }

    public EmployeeRequest(String firstName, String middleName, String lastName, String secondLastName,
                           String identificationNumber, int identificationTypeCode,
                           int countryCode, int workFieldCode) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.identificationNumber = identificationNumber;
        this.identificationTypeCode = identificationTypeCode;
        this.countryCode = countryCode;
        this.workFieldCode = workFieldCode;
    }

    public EmployeeRequest(String firstName, String lastName, String secondLastName, String identificationNumber,
                           int identificationTypeCode, int countryCode, int workFieldCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.identificationNumber = identificationNumber;
        this.identificationTypeCode = identificationTypeCode;
        this.countryCode = countryCode;
        this.workFieldCode = workFieldCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase(Locale.ROOT);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.toUpperCase(Locale.ROOT);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase(Locale.ROOT);
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName.toUpperCase(Locale.ROOT);
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber.toUpperCase(Locale.ROOT);
    }

    public int getIdentificationTypeCode() {
        return identificationTypeCode;
    }

    public void setIdentificationTypeCode(int identificationTypeCode) {
        this.identificationTypeCode = identificationTypeCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getWorkFieldCode() {
        return workFieldCode;
    }

    public void setWorkFieldCode(int workFieldCode) {
        this.workFieldCode = workFieldCode;
    }
}
