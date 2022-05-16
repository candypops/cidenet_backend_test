package com.cidenet.cidenet.rest;

import com.cidenet.cidenet.dto.EmployeeRequest;
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

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    private ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRequest employee){
        System.out.println("getIdentificationTypeCode");
        System.out.println(employee.getIdentificationTypeCode());
        Optional<IdentificationType> optionalIdentificationType =
                identificationTypeService.getIdentificationTypeById((long) employee.getIdentificationTypeCode());
        Employee e = new Employee( "email", "ACTIVE",
                employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getSecondLastName(),
                employee.getIdentificationNumber(), new Date(), new Date());
        if(optionalIdentificationType.isPresent()){
            IdentificationType identificationType = optionalIdentificationType.get();
            e.setIdentificationType(identificationType);
        }
        employeeService.saveNewEmployee(e);
        try {
            return ResponseEntity.created(new URI("api/v1/save-employee"+e.getEmail())).body(e);
        }catch (Exception ex){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    @RequestMapping(path = "/employees")
    private ResponseEntity<List<Employee>> getAllEmployees(){
        return  ResponseEntity.ok(employeeService.getAllActiveEmployees());
    }

}
