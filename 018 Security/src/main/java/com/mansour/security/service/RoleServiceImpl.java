package com.mansour.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.security.base.BaseService;
import com.mansour.security.entity.Role;
import com.mansour.security.repository.RoleJPARepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleServiceImpl implements BaseService<Role, Long> {
    private final RoleJPARepository roleJPARepository;

    public RoleServiceImpl(RoleJPARepository roleJPARepository) {
        this.roleJPARepository = roleJPARepository;
    }

    @Override
    public List<Role> findAll() {
        return roleJPARepository.findAll();
    }

    @Override
    public Role getById(Long id) throws EntityNotFoundException {
        return roleJPARepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

    }

    @Override
    public Role create(Role t) {
        return roleJPARepository.save(t);

    }

    @Override
    public Role delete(Long id) {
        Role role = roleJPARepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        roleJPARepository.deleteById(id);
        return role;
    }

    @Override
    public Role update(Role t) {
        return roleJPARepository.save(t);

    }

    @Override
    public Role findByName(String name) {
        return roleJPARepository.findByName(name);
    }

}
