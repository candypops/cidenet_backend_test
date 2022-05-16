package com.cidenet.cidenet.service;

import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

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

    public void saveNewEmployee(@Valid Employee employee) {
        generateEmail(employee, 0);
        employeeRepository.save(employee);
    }

    public boolean isEmailDuplicated(String email) {
        return employeeRepository.findByEmail(email) != null;
    }

    public Employee editEmployee(Employee employee) {
        return employee;
    }

    public void something() {
        System.out.println("AAAAAAAAAAAAAAAAAAAA");
    }

    public void generateEmail(Employee employee, int id) {
        String identifier = id > 0 ? "." + id : "";
        String email = StringUtils.trimAllWhitespace(employee.getLastName()) + "." + employee.getFirstName() +
                identifier + "@cidenet.com";
        if (isEmailDuplicated(email)) {
            generateEmail(employee, id+1);
        }else{
            employee.setEmail(email);
        }
    }


}
