package com.mansour.springannotations.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mansour.springannotations.models.User;
import java.util.List;

@Repository
public interface UserJDBCRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
