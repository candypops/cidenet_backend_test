package com.cidenet.cidenet.repository;

import com.cidenet.cidenet.model.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {

    @Query("SELECT i FROM IdentificationType i WHERE i.status = 'ACTIVE'")
    List<IdentificationType> findAllActiveIdentificationTypes();

}