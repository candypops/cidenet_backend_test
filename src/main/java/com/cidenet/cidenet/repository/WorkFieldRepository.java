package com.cidenet.cidenet.repository;

import com.cidenet.cidenet.model.WorkField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkFieldRepository extends JpaRepository<WorkField, Long> {

    @Query("SELECT w FROM WorkField w WHERE w.status = 'ACTIVE'")
    List<WorkField> findAllActiveWorkfields();
}