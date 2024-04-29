package com.mansour.springdatajdbc.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mansour.springdatajdbc.models.User;

public interface UserService {
@Transactional
    int count();

@Transactional
    User getUser(long id);

@Transactional
    List<User> getUserByName(String name);

@Transactional
    List<User> getUsers();

@Transactional
    void createUser(User user);

@Transactional
    User updatUser(User user);

@Transactional
    User deleteUser(long id);

}
