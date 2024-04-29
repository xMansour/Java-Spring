package com.mansour.jpa.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.mansour.jpa.dto.DepartmentDTO;
import com.mansour.jpa.model.Department;

@Component
public class DepartmentDTOMapper implements Function<Department, DepartmentDTO> {

    @Override
    public DepartmentDTO apply(Department department) {
        if (department != null)
            return new DepartmentDTO(department.getName());
        else
            return new DepartmentDTO("");
    }

}
