package com.mansour.auditing.base;

import java.util.List;

import com.mansour.auditing.exception.EntityNotFoundException;

import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public interface BaseService<T, ID> {
    List<T> findAll();

    T getEmployeeById(ID id) throws EntityNotFoundException;

    T createEmployee(T employee);

    T deleteEmployee(ID id);

    T updateEmployee(T employee);
}
