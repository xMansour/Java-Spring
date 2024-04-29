package com.mansour.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mansour.jpa.model.UserRole;

@Repository
public interface RoleRepository extends CrudRepository<UserRole, Long> {

}
