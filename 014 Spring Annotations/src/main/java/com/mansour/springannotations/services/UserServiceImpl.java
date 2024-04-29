package com.mansour.springannotations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mansour.springannotations.models.User;
import com.mansour.springannotations.repositories.UserJDBCRepository;
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserJDBCRepository userRepository;

    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(long id) {
        User user = getUser(id);
        userRepository.deleteById(id);
        return user;
    }

}
