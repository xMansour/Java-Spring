package com.mansour.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.mansour.jpa.dto.UserDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUser(Long id) throws ResourceNotFoundException;

    Page<UserDTO> getUsersPagable(Pageable pageable);

    UserDTO createUser(User user);

    UserDTO updateUser(User user);

    UserDTO deleteUser(Long id) throws ResourceNotFoundException;

    List<UserDTO> findByDepartmentName(String name);

    List<UserDTO> filter(String name, Direction direction, String sortingProperty);

    List<UserDTO> filterNativeQuery(String name);

    UserStatisticProjection getUserStatisticProjection();

}
