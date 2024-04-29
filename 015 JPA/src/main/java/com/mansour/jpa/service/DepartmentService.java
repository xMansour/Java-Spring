package com.mansour.jpa.service;

import java.util.List;

import com.mansour.jpa.dto.DepartmentDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.Department;

public interface DepartmentService {
    List<DepartmentDTO> getDepartments();

    DepartmentDTO getDepartment(Long id) throws ResourceNotFoundException;

    DepartmentDTO createDepartment(Department department);

    DepartmentDTO updateDepartment(Department department);

    DepartmentDTO deleteDepartment(Long id) throws ResourceNotFoundException;
}
