package com.cidenet.cidenet.rest;

import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.service.WorkFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "api/v1/get-work-fields")
public class WorkFieldREST {

    private final WorkFieldService workFieldService;

    @Autowired
    public WorkFieldREST(WorkFieldService workFieldService) {
        this.workFieldService = workFieldService;
    }

    @GetMapping
    private ResponseEntity<List<WorkField>> getALlActiveWorkFields() {
        return ResponseEntity.ok(workFieldService.getAllActiveWorkFields());
    }

}
