package com.mansour.springdatajdbc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mansour.springdatajdbc.models.User;
import java.util.List;



public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByName(String name);

}
