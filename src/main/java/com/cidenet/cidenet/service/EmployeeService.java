package com.cidenet.cidenet.service;

import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class EmployeeService {
    private final CountryService countryService;
    private final IdentificationTypeService identificationTypeService;
    private final WorkFieldService workFieldService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(CountryService countryService,
                           IdentificationTypeService identificationTypeService,
                           WorkFieldService workFieldService,
                           EmployeeRepository employeeRepository) {
        this.countryService = countryService;
        this.identificationTypeService = identificationTypeService;
        this.workFieldService = workFieldService;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllActiveEmployees(){
        return employeeRepository.getAllActiveEmployees();
    }

    public void saveNewEmployee(@Valid Employee employee){
        employeeRepository.save(employee);
    }

    public Employee editEmployee(Employee employee){
        return employee;
    }

    public void something(){
        System.out.println("AAAAAAAAAAAAAAAAAAAA");
    }


}
