package com.cidenet.cidenet.repository;

import com.cidenet.cidenet.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
