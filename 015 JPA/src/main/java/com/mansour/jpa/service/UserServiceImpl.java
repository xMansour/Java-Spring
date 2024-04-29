package com.mansour.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mansour.jpa.dto.UserDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.mapper.UserDTOMapper;
import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;
import com.mansour.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserDTOMapper userDTOMapper;

    public UserServiceImpl(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(userDTOMapper).toList();
    }

    @Override
    public UserDTO getUser(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).map(userDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id:%s not found".formatted(id)));
    }

    @Override
    public UserDTO createUser(User user) {
        User createdUser = userRepository.save(user);
        return userDTOMapper.apply(createdUser);
    }

    @Override
    public UserDTO updateUser(User user) {
        User updatedUser = userRepository.save(user);
        return userDTOMapper.apply(updatedUser);
    }

    @Override
    public UserDTO deleteUser(Long id) throws ResourceNotFoundException {
        UserDTO deletedUser = getUser(id);
        userRepository.deleteById(id);
        return deletedUser;
    }

    @Override
    public List<UserDTO> findByDepartmentName(String name) {
        return userRepository.findByDepartmentName(name).stream().map(userDTOMapper).toList();
    }

    @Override
    public List<UserDTO> filter(String name, Direction direction, String sortingProperty) {
        return userRepository.filter(name, Sort.by(direction, sortingProperty)).stream().map(userDTOMapper).toList();
    }

    @Override
    public List<UserDTO> filterNativeQuery(String name) {
        return userRepository.filterNativeQuery(name).stream().map(userDTOMapper).toList();
    }

    @Override
    public UserStatisticProjection getUserStatisticProjection() {
        return userRepository.getUserStatisticProjection();
    }

    @Override
    public Page<UserDTO> getUsersPagable(Pageable pageable) {
        return userRepository.findAll(pageable).map(userDTOMapper);
    }

}
