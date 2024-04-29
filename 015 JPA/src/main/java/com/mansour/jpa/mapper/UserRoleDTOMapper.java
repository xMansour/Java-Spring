package com.mansour.jpa.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.mansour.jpa.dto.UserRoleDTO;
import com.mansour.jpa.model.Role;
import com.mansour.jpa.model.UserRole;

@Component
public class UserRoleDTOMapper implements Function<UserRole, UserRoleDTO> {

    @Override
    public UserRoleDTO apply(UserRole userRole) {
        if (userRole != null)
            return new UserRoleDTO(userRole.getRole());
        else
            return new UserRoleDTO(Role.DEFAULT);
    }

}
