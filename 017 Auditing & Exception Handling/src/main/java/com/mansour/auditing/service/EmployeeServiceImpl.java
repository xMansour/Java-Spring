package com.mansour.auditing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.auditing.base.BaseRepository;
import com.mansour.auditing.base.BaseService;
import com.mansour.auditing.entity.Employee;
import com.mansour.auditing.exception.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements BaseService<Employee, Long> {
    private final BaseRepository<Employee, Long> BaseRepository;

    public EmployeeServiceImpl(BaseRepository<Employee, Long> BaseRepository) {
        this.BaseRepository = BaseRepository;
    }

    @Override
    public List<Employee> findAll() {
        return BaseRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return BaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id:%s not found".formatted(id)));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return BaseRepository.save(employee);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = BaseRepository.findById(id).get();
        BaseRepository.deleteById(id);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return BaseRepository.save(employee);
    }

}
