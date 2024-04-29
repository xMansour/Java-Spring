package com.mansour.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mansour.jpa.model.Department;
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
