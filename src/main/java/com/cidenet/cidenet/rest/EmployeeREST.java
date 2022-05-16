package com.cidenet.cidenet.rest;

import com.cidenet.cidenet.dto.EmployeeRequest;
import com.cidenet.cidenet.exception.DuplicateIdentificationException;
import com.cidenet.cidenet.exception.ResourceNotFoundException;
import com.cidenet.cidenet.exception.UnexpectedErrorException;
import com.cidenet.cidenet.model.Country;
import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.model.IdentificationType;
import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.service.CountryService;
import com.cidenet.cidenet.service.EmployeeService;
import com.cidenet.cidenet.service.IdentificationTypeService;
import com.cidenet.cidenet.service.WorkFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    private ResponseEntity<List<Country>> getAllActiveCountries() {
        return ResponseEntity.ok(countryService.getAllActiveCountries());
    }

    @GetMapping
    @RequestMapping(path = "/get-identification-types")
    private ResponseEntity<List<IdentificationType>> getAllActiveIdentificationTypes() {
        return ResponseEntity.ok(identificationTypeService.getAllActiveIdentificationTypes());
    }

    @PostMapping
    @RequestMapping(path = "/save-employee", method = RequestMethod.POST)
    private ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRequest employee) {
        Employee e = buildEmployee(employee);
        e.setCreationDate(getCurrentDate());
        e.setModificationDate(getCurrentDate());
        e = employeeService.saveNewEmployee(e);
        try {
            return ResponseEntity.created(new URI("api/v1/save-employee/" + e.getEmail())).body(e);
        } catch (UnexpectedErrorException ex){
            throw  new UnexpectedErrorException();
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    @RequestMapping(path = "/employees")
    private ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllActiveEmployees());
    }

    @GetMapping
    @RequestMapping(path = "/employees/paged")
    private ResponseEntity<Page<Employee>> getAllEmployees(Pageable pageable) {
        return ResponseEntity.ok(employeeService.getAllActiveEmployees(pageable));
    }

    @PutMapping
    @RequestMapping(path = "/update-employee", method = RequestMethod.PUT)
    private ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeRequest employee) {
        Employee e = buildEmployee(employee);
        e.setId((long) employee.getId());
        e.setModificationDate(getCurrentDate());
        try {
            e = employeeService.editEmployee(e);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException();
        } catch (DuplicateIdentificationException ex) {
            throw new DuplicateIdentificationException();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.ok(e);
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(new Date());
    }

    private Employee buildEmployee(EmployeeRequest employee) throws UnexpectedErrorException {
        Optional<IdentificationType> optionalIdentificationType =
                identificationTypeService.getIdentificationTypeById((long) employee.getIdentificationTypeCode());
        Optional<Country> optionalCountry =
                countryService.getCountryById((long) employee.getCountryCode());
        Optional<WorkField> optionalWorkField =
                workFieldService.getWorkFieldById((long) employee.getWorkFieldCode());
        String status = Objects.isNull(employee.getStatus()) ? "ACTIVE" : employee.getStatus().toString();
        Employee e = new Employee("email", status,
                employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getSecondLastName(),
                employee.getIdentificationNumber());
        if (optionalIdentificationType.isPresent() && optionalCountry.isPresent() && optionalWorkField.isPresent()) {
            IdentificationType identificationType = optionalIdentificationType.get();
            Country country = optionalCountry.get();
            WorkField workField = optionalWorkField.get();
            e.setCountry(country);
            e.setIdentificationType(identificationType);
            e.setWorkField(workField);
        }else{
            throw new UnexpectedErrorException();
        }
        return e;
    }


}
