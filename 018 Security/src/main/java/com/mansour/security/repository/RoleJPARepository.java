package com.mansour.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mansour.security.entity.Role;

@Repository
public interface RoleJPARepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
