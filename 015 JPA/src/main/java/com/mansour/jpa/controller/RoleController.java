package com.mansour.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.jpa.dto.UserRoleDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.UserRole;
import com.mansour.jpa.service.RoleService;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<UserRoleDTO> getUserRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public UserRoleDTO getRole(@PathVariable Long id) {
        try {
            return roleService.getRole(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new UserRoleDTO(null);
        }
    }

    @PostMapping()
    public UserRoleDTO creatRole(@RequestBody UserRole userRole) {
        return roleService.createRole(userRole);
    }

    @PutMapping()
    public UserRoleDTO updateRole(@RequestBody UserRole userRole) {
        return roleService.updateRole(userRole);
    }

    @DeleteMapping("/{id}")
    public UserRoleDTO deleteRole(@PathVariable Long id) {
        try {
            return roleService.deleteRole(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new UserRoleDTO(null);
        }
    }

}
