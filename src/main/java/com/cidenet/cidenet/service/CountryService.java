package com.cidenet.cidenet.service;

import com.cidenet.cidenet.model.Country;
import com.cidenet.cidenet.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllActiveCountries() {
        return countryRepository.findAllActiveCountries();
    }
    
    public Optional<Country> getCountryById(Long id){
        return countryRepository.findById(id);
        
    }
}
