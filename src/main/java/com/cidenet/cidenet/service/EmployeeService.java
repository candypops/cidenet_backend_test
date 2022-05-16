package com.cidenet.cidenet.service;

import com.cidenet.cidenet.exception.DuplicateIdentificationException;
import com.cidenet.cidenet.exception.ResourceNotFoundException;
import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.getAllActiveEmployees();
    }

    public Page<Employee> getAllActiveEmployees(Pageable pageable) {
        return employeeRepository.getAllActiveEmployees(pageable);
    }


    public Employee saveNewEmployee(@Valid Employee employee) throws DuplicateIdentificationException {
        isIdentificationDuplicated(employee);
        employee.setEmail(generateEmail(employee, 0));
        return employeeRepository.save(employee);
    }

    private boolean isEmailDuplicated(String email) {
        return employeeRepository.existsByEmail(email);
    }

    private void isIdentificationDuplicated(Employee employee) throws DuplicateIdentificationException {
        if (employeeRepository.existsByidentificationNumber(employee.getIdentificationNumber())
                && employeeRepository.existsByidentificationType(employee.getIdentificationType())) {
            throw new DuplicateIdentificationException();
        }
    }

    public Employee editEmployee(Employee employee) throws ResourceNotFoundException, DuplicateIdentificationException {
        Employee e = employeeRepository.findById(employee.getId()).orElseThrow(ResourceNotFoundException::new);
        if (!e.getIdentificationNumber().equalsIgnoreCase(employee.getIdentificationNumber()) ||
                !e.getIdentificationType().getId().equals(employee.getIdentificationType().getId())) {
            isIdentificationDuplicated(employee);
        }
        employee.setEmail(e.getEmail());
        employee.setCreationDate(e.getCreationDate());
        if (!e.getFirstName().equalsIgnoreCase(employee.getFirstName()) ||
                !e.getMiddleName().equalsIgnoreCase(employee.getMiddleName()) ||
                !e.getLastName().equalsIgnoreCase(employee.getLastName()) ||
                !e.getSecondLastName().equalsIgnoreCase(employee.getSecondLastName()) ||
                !e.getCountry().equals(employee.getCountry())
        ) {
            employee.setEmail(generateEmail(employee, 0));
        }
        return employeeRepository.save(employee);
    }

    public String generateEmail(Employee employee, int id) {
        String identifier = id > 0 ? "." + id : "";
        String domain = Objects.equals(employee.getCountry().getName(), "COLOMBIA") ? "@cidenet.com.co" : "@cidenet.com.us";
        String email = StringUtils.trimAllWhitespace(employee.getLastName()) + "." + employee.getFirstName() +
                identifier + domain;
        email = email.toUpperCase(Locale.ROOT);
        if (isEmailDuplicated(email.toUpperCase(Locale.ROOT))) {
            email = generateEmail(employee, id + 1);
        }
        return email;
    }


}
