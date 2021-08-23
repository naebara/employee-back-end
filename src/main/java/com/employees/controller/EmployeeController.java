package com.employees.controller;

import com.employees.model.Employee;
import com.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @DeleteMapping("/{employeeId}")
    public Employee deleteEmployee(@PathVariable(name = "employeeId") int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
