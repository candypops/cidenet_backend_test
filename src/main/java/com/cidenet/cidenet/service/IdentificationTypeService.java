package com.cidenet.cidenet.service;

import com.cidenet.cidenet.model.IdentificationType;
import com.cidenet.cidenet.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificationTypeService {
    private final IdentificationTypeRepository identificationTypeRepository;

    @Autowired
    public IdentificationTypeService(IdentificationTypeRepository identificationTypeRepository) {
        this.identificationTypeRepository = identificationTypeRepository;
    }

    public List<IdentificationType> getAllActiveIdentificationTypes(){
        return identificationTypeRepository.findAllActiveIdentificationTypes();
    }
}
