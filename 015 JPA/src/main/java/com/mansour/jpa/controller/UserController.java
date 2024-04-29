package com.mansour.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.jpa.dto.UserDTO;
import com.mansour.jpa.exceptions.ResourceNotFoundException;
import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;
import com.mansour.jpa.service.UserService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        try {
            return userService.getUser(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new UserDTO(null, null, null, 0, null, null, null);
        }
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable Long id) {
        try {
            return userService.deleteUser(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return new UserDTO(null, null, null, 0, null, null, null);
        }
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/departments/{name}")
    public List<UserDTO> findUsersByDeparmentName(@PathVariable String name) {
        return userService.findByDepartmentName(name);
    }

    @GetMapping("/filter/{name}")
    public List<UserDTO> filterUsersByName(@PathVariable String name, @RequestParam boolean isAsc,
            @RequestParam String sortingProperty) {
        return userService.filter(name, isAsc ? Direction.ASC : Direction.DESC, sortingProperty);
    }

    @GetMapping("/page/{id}")
    public Page<UserDTO> getUsersPagable(@PathVariable int id, @RequestParam int pageSize, @RequestParam boolean isAsc,
            @RequestParam String sortingProperty) {
        return userService.getUsersPagable(
                PageRequest.of(id, pageSize, Sort.by(isAsc ? Direction.ASC : Direction.DESC, sortingProperty)));
    }

    @GetMapping("/status")
    public UserStatisticProjection getUserStatisticProjection() {
        return userService.getUserStatisticProjection();
    }

}
