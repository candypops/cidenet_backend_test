package com.cidenet.cidenet.repository;

import com.cidenet.cidenet.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c WHERE c.status = 'ACTIVE'")
    List<Country> findAllActiveCountries();
}
