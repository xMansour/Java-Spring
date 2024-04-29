package com.mansour.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.jpa.dto.DepartmentDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.Department;
import com.mansour.jpa.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<DepartmentDTO> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        try {
            return departmentService.getDepartment(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new DepartmentDTO(null);
        }
    }

    @PostMapping()
    public DepartmentDTO createDepartment(@RequestBody Department Department) {
        return departmentService.createDepartment(Department);
    }

    @DeleteMapping("/{id}")
    public DepartmentDTO deleteDepartment(@PathVariable Long id) {
        try {
            return departmentService.deleteDepartment(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new DepartmentDTO(null);
        }

    }

    @PutMapping()
    public DepartmentDTO updateDepartment(@RequestBody Department Department) {
        return departmentService.updateDepartment(Department);
    }
}
