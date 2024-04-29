package com.mansour.jpa.service;

import java.util.List;

import com.mansour.jpa.dto.UserRoleDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.UserRole;

public interface RoleService {
    List<UserRoleDTO> getRoles();

    UserRoleDTO getRole(Long id) throws ResourceNotFoundException;

    UserRoleDTO createRole(UserRole role);

    UserRoleDTO updateRole(UserRole role);

    UserRoleDTO deleteRole(Long id) throws ResourceNotFoundException;

}
