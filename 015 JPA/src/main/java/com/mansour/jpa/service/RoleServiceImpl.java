package com.mansour.jpa.service;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import com.mansour.jpa.dto.UserRoleDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.mapper.UserRoleDTOMapper;
import com.mansour.jpa.model.UserRole;
import com.mansour.jpa.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private UserRoleDTOMapper userRoleDTOMapper;

    public RoleServiceImpl(RoleRepository roleRepository, UserRoleDTOMapper userRoleDTOMapper) {
        this.roleRepository = roleRepository;
        this.userRoleDTOMapper = userRoleDTOMapper;
    }

    @Override
    public List<UserRoleDTO> getRoles() {
        return Streams.stream(roleRepository.findAll()).map(userRoleDTOMapper).toList();
    }

    @Override
    public UserRoleDTO getRole(Long id) throws ResourceNotFoundException {
        return roleRepository.findById(id).map(userRoleDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id:%s not found".formatted(id)));
    }

    @Override
    public UserRoleDTO createRole(UserRole role) {
        UserRole createdRole = roleRepository.save(role);
        return userRoleDTOMapper.apply(createdRole);
    }

    @Override
    public UserRoleDTO updateRole(UserRole role) {
        UserRole updatedUserRole = roleRepository.save(role);
        return userRoleDTOMapper.apply(updatedUserRole);
    }

    @Override
    public UserRoleDTO deleteRole(Long id) throws ResourceNotFoundException {
        UserRoleDTO userRoleDTO = getRole(id);
        roleRepository.deleteById(id);
        return userRoleDTO;
    }

}
