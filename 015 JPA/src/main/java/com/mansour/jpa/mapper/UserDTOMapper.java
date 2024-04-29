package com.mansour.jpa.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.mansour.jpa.dto.UserDTO;
import com.mansour.jpa.model.User;

@Component
public class UserDTOMapper implements Function<User, UserDTO> {
    private final DepartmentDTOMapper departmentDTOMapper;
    private final AccountDTOMapper accountDTOMapper;
    private final UserRoleDTOMapper userRoleDTOMapper;

    public UserDTOMapper(DepartmentDTOMapper departmentDTOMapper, AccountDTOMapper accountDTOMapper,
            UserRoleDTOMapper userRoleDTOMapper) {
        this.departmentDTOMapper = departmentDTOMapper;
        this.accountDTOMapper = accountDTOMapper;
        this.userRoleDTOMapper = userRoleDTOMapper;
    }

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getGender(), user.getAge(),
                departmentDTOMapper.apply(user.getDepartment()),
                accountDTOMapper.apply(user.getAccount()), user.getUserRole().stream().map(userRoleDTOMapper).toList());
    }

}
