package com.mansour.projection.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mansour.projection.service.ActorService;

@Component
public class AppConfig implements CommandLineRunner {

    private final ActorService actorService;

    public AppConfig(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public void run(String... args) throws Exception {
        // System.out.println(actorService.getActorClassProjection());
        System.out.println("First Name: " + actorService.getActorInterfaceProjection().getFirstName());
        System.out.println("Last Name: " + actorService.getActorInterfaceProjection().getLastName());
        System.out.println("Full Name: " + actorService.getActorInterfaceProjection().getFullName());

    }

}
