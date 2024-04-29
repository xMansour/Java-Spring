package com.mansour.auditing.repository;

import org.springframework.stereotype.Repository;

import com.mansour.auditing.base.BaseRepository;
import com.mansour.auditing.entity.Employee;

@Repository
public interface EmployeeJPARepository extends BaseRepository<Employee, Long> {

}
