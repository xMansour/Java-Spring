package com.mansour.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import com.mansour.jpa.dto.DepartmentDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.mapper.DepartmentDTOMapper;
import com.mansour.jpa.model.Department;
import com.mansour.jpa.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentDTOMapper departmentDTOMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentDTOMapper departmentDTOMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentDTOMapper = departmentDTOMapper;
    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        return Streams.stream(departmentRepository.findAll()).map(departmentDTOMapper).toList();
    }

    @Override
    public DepartmentDTO getDepartment(Long id) throws ResourceNotFoundException {
        return departmentRepository.findById(id).map(departmentDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Department with id:%s not found".formatted(id)));
    }

    @Override
    public DepartmentDTO createDepartment(Department department) {
        Department createdDepartment = departmentRepository.save(department);
        return departmentDTOMapper.apply(createdDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(Department department) {
        Department updatedDepartment = departmentRepository.save(department);
        return departmentDTOMapper.apply(updatedDepartment);
    }

    @Override
    public DepartmentDTO deleteDepartment(Long id) throws ResourceNotFoundException {
        DepartmentDTO deletedDepartment = getDepartment(id);
        departmentRepository.deleteById(id);
        return deletedDepartment;
    }

}
