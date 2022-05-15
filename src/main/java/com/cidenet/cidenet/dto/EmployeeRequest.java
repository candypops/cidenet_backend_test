package com.cidenet.cidenet.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeeRequest {

    @NotEmpty(message = "Primer nombre no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Primer nombre invalido")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Segundo nombre invalido")
    private String middleName;

    @NotEmpty(message = "Primer apellido no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Primer apellido invalido")
    private String lastName;

    @NotEmpty(message = "Segundo apellido no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Segundo apellido invalido")
    private String secondLastName;

    @NotEmpty(message = "Numero de empleado no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Numero de empleado invalido")
    private String employeeId;

    public EmployeeRequest(){

    }

    public EmployeeRequest(String firstName, String middleName, String lastName, String secondLastName, String employeeId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.employeeId = employeeId;
    }

    public EmployeeRequest(String firstName, String lastName, String secondLastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.employeeId = employeeId;
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
}
