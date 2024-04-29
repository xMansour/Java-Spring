package com.mansour.projection.service;

import java.util.List;

import com.mansour.projection.entities.Actor;
import com.mansour.projection.projections.ActorProjection;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(Long id) throws ResourceNotFoundException;

    Actor getActorClassProjection();

    ActorProjection getActorInterfaceProjection();

    Actor create(Actor actor);

    Actor update(Actor actor);

    Actor deleteById(Long id) throws ResourceNotFoundException;
}
