package com.cidenet.cidenet.rest;

import com.cidenet.cidenet.model.Country;
import com.cidenet.cidenet.model.IdentificationType;
import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.service.CountryService;
import com.cidenet.cidenet.service.IdentificationTypeService;
import com.cidenet.cidenet.service.WorkFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeREST {

    private final WorkFieldService workFieldService;
    private final CountryService countryService;
    private final IdentificationTypeService identificationTypeService;

    @Autowired
    public EmployeeREST(WorkFieldService workFieldService,
                        CountryService countryService,
                        IdentificationTypeService identificationTypeService
                        ) {
        this.workFieldService = workFieldService;
        this.countryService = countryService;
        this.identificationTypeService = identificationTypeService;
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
}
