package com.mansour.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.security.base.BaseService;
import com.mansour.security.entity.Role;

@RestController
@RequestMapping("/api/v1/security-roles")
public class RoleController {
    private final BaseService<Role, Long> roleService;

    public RoleController(@Qualifier("roleServiceImpl") BaseService<Role, Long> roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<Role> findAll() {
        return roleService.findAll();
    }

}
