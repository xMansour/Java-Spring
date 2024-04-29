package com.mansour.jpa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mansour.jpa.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// @Component
public class DatabaseConfig implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("INSIDE THE RUN METHOD OF THE COMMANDLINERUNNER");
        //createUser();
        findUser();
    }

    // private void createUser() {
    //     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.xml");
    //     EntityManager entityManager = entityManagerFactory.createEntityManager();
    //     entityManager.getTransaction().begin();
    //     User user = new User("Mohamed", "Male", 15);
    //     entityManager.persist(user);
    //     entityManager.getTransaction().commit();
    //     entityManager.close();
    //     entityManagerFactory.close();
    // }

    private void findUser() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.xml");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, 1);
        logger.info("User with id = 1 is: " + user);
    }

}
