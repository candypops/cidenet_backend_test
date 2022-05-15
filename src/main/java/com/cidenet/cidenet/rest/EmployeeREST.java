package com.cidenet.cidenet.rest;

import com.cidenet.cidenet.model.Country;
import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.model.IdentificationType;
import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.service.CountryService;
import com.cidenet.cidenet.service.EmployeeService;
import com.cidenet.cidenet.service.IdentificationTypeService;
import com.cidenet.cidenet.service.WorkFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeREST {

    private final WorkFieldService workFieldService;
    private final CountryService countryService;
    private final IdentificationTypeService identificationTypeService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeREST(WorkFieldService workFieldService,
                        CountryService countryService,
                        IdentificationTypeService identificationTypeService,
                        EmployeeService employeeService) {
        this.workFieldService = workFieldService;
        this.countryService = countryService;
        this.identificationTypeService = identificationTypeService;
        this.employeeService = employeeService;
    }

    @GetMapping
    @RequestMapping(path = "/get-work-fields")
    private ResponseEntity<List<WorkField>> getALlActiveWorkFields() {
        return ResponseEntity.ok(workFieldService.getAllActiveWorkFields());
    }

    @GetMapping
    @RequestMapping(path = "/get-countries")
    private ResponseEntity<List<Country>> getAllActiveCountries(){
        return ResponseEntity.ok(countryService.getAllActiveCountries());
    }

    @GetMapping
    @RequestMapping(path = "/get-identification-types")
    private  ResponseEntity<List<IdentificationType>> getAllActiveIdentificationTypes(){
        return  ResponseEntity.ok(identificationTypeService.getAllActiveIdentificationTypes());
    }

    @PostMapping
    @RequestMapping(path = "/save-employee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        employeeService.something();
        try {
            employeeService.saveNewEmployee(employee);
            return ResponseEntity.created(new URI("api/v1/save-employee"+employee.getEmail())).body(employee);
        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    @RequestMapping(path = "/employees")
    private ResponseEntity<List<Employee>> getAllEmployees(){
        return  ResponseEntity.ok(employeeService.getAllActiveEmployees());
    }

}
