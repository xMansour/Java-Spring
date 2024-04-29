package com.mansour.auditing.service;

import java.util.List;

import com.mansour.auditing.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

}
