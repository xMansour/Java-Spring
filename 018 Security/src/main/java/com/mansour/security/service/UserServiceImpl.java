package com.mansour.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mansour.security.base.BaseService;
import com.mansour.security.entity.AppUser;
import com.mansour.security.repository.UserJPARepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements BaseService<AppUser, Long> {
    private final UserJPARepository userJPARepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserJPARepository userJPARepository, PasswordEncoder passwordEncoder) {
        this.userJPARepository = userJPARepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<AppUser> findAll() {
        return userJPARepository.findAll();
    }

    @Override
    public AppUser getById(Long id) throws EntityNotFoundException {
        return userJPARepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public AppUser create(AppUser t) {
        t.setPassword(passwordEncoder.encode(t.getPassword()));
        return userJPARepository.save(t);
    }

    @Override
    public AppUser delete(Long id) {
        AppUser appUser = userJPARepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        userJPARepository.deleteById(id);
        return appUser;
    }

    @Override
    public AppUser update(AppUser t) {
        return userJPARepository.save(t);
    }

}
