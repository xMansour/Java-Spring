package com.mansour.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mansour.jpa.model.User;
import com.mansour.jpa.model.UserStatisticProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDepartmentName(String name);

    // JPQL
    @Query(value = "select user from User user where user.name like %:name%")
    List<User> filter(@Param(value = "name") String name, Sort sort);

    // Native Query
    @Query(value = "select * from user where user.name like %:name%", nativeQuery = true)
    List<User> filterNativeQuery(@Param(value = "name") String name);

    @Query(value = "select (select count(*) from user) userCount, (select count(*) from department) departmentCount, (select count(*) from account) accountCount", nativeQuery = true)
    UserStatisticProjection getUserStatisticProjection();

}
