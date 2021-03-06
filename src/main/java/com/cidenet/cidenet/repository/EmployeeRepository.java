package com.cidenet.cidenet.repository;

import com.cidenet.cidenet.model.Employee;
import com.cidenet.cidenet.model.IdentificationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.status='ACTIVE'")
    List<Employee> getAllActiveEmployees();

    @Query("SELECT e FROM Employee e WHERE e.status='ACTIVE'")
    Page<Employee> getAllActiveEmployees(Pageable pageable);

    boolean existsByEmail(String email);

    boolean existsByidentificationType(IdentificationType id);

    boolean existsByidentificationNumber(String id);



}
