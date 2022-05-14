package com.cidenet.cidenet.controller;

import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.service.WorkFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/get-work-fields")
public class WorkFieldController {

    private final WorkFieldService workFieldService;

    @Autowired
    public WorkFieldController(WorkFieldService workFieldService) {
        this.workFieldService = workFieldService;
    }

    @GetMapping
    public List<WorkField> getWorkFields() {
        return workFieldService.getWorkFields();
    }
}
