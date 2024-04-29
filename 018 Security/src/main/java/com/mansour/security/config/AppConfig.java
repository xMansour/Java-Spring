package com.mansour.security.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mansour.security.base.BaseService;
import com.mansour.security.entity.AppUser;
import com.mansour.security.entity.Role;

@Component
public class AppConfig implements CommandLineRunner {
    private final BaseService<AppUser, Long> userService;
    private final BaseService<Role, Long> roleService;

    public AppConfig(BaseService<AppUser, Long> userService, BaseService<Role, Long> roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleService.findAll().isEmpty()) {
            roleService.create(new Role("ADMIN"));
            roleService.create(new Role("USER"));
        }

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.addAll(roleService.findAll());

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findByName("USER"));

        if (userService.findAll().isEmpty()) {
            userService.create(new AppUser("Mahmoud", "mahmoud", "Password123", adminRoles));
            userService.create(new AppUser("Ahmed", "ahmed", "pass1543", userRoles));
        }

    }

}
