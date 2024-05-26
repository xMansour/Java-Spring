package com.mansour.lombok.employees;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.mansour.lombok.shared.base.BaseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements BaseService<Employee, Long> {
    private final EmployeeRepository employeeRepository;

    @Override
    @Cacheable(cacheNames = "employeesCache", key = "#root.methodName", cacheManager = "caffeineCacheManager")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "employeeCache", key = "#id", cacheManager = "caffeineCacheManager")
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id:%s not found".formatted(id)));
    }

    @Override
    @CacheEvict(cacheNames = "employeesCache", allEntries = true, cacheManager = "caffeineCacheManager")
    public Employee create(Employee obj) {
        return employeeRepository.save(obj);
    }

    @Override
    @Caching(evict = @CacheEvict(cacheNames = "employeesCache", allEntries = true, cacheManager = "caffeineCacheManager"), put = @CachePut(cacheNames = "employeeCache", key = "#obj.id", cacheManager = "caffeineCacheManager"))
    public Employee update(Employee obj) {
        return employeeRepository.save(obj);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "employeesCache", allEntries = true, cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheNames = "employeeCache", key = "#id", cacheManager = "caffeineCacheManager") })
    public Employee delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id:%s not found".formatted(id)));
        employeeRepository.deleteById(id);
        return employee;
    }

}
