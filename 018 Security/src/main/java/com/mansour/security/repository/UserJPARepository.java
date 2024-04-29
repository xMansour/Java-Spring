package com.mansour.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mansour.security.entity.AppUser;

@Repository
public interface UserJPARepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUserName(String userName);

}
