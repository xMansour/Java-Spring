package com.mansour.auditing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.auditing.base.BaseService;
import com.mansour.auditing.entity.Employee;
import com.mansour.auditing.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final BaseService<Employee, Long> employeeService;

    public EmployeeController(BaseService<Employee, Long> employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public Employee creatEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Employee deletEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping()
    public Employee updatEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}
