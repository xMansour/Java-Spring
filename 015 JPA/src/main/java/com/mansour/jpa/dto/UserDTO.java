package com.mansour.jpa.dto;

import java.util.List;

public record UserDTO(Long id, String name, String gender, int age, DepartmentDTO departmentDTO, AccountDTO accountDTO,
        List<UserRoleDTO> userRoleDTO) {
}
