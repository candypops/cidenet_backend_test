package com.cidenet.cidenet.service;

import com.cidenet.cidenet.model.WorkField;
import com.cidenet.cidenet.repository.WorkFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkFieldService {

    private final WorkFieldRepository workFieldRepository;

    @Autowired
    public WorkFieldService(WorkFieldRepository workFieldRepository) {
        this.workFieldRepository = workFieldRepository;
    }


    public List<WorkField> getAllActiveWorkFields(){
        return workFieldRepository.findAllActiveWorkfields();
    }

    public Optional<WorkField> getWorkFieldById(long id){
        return  workFieldRepository.findById(id);
    }
}
