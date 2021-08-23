package com.employees.repository;

import com.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // findAll
    // getById()
}
