package com.employees.service;

import com.employees.model.Employee;
import com.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
       return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getById(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " was not found"));
    }

    public Employee deleteEmployee(int id){
         Employee e = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " was not found"));
         employeeRepository.delete(e);
         return e;
    }

    public Employee update(Employee employee) {
        int id = employee.getId();
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " was not found"));
        return employeeRepository.save(employee);
    }
}
