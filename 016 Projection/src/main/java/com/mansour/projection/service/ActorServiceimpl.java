package com.mansour.projection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mansour.projection.entities.Actor;
import com.mansour.projection.projections.ActorProjection;
import com.mansour.projection.repository.ActorJPARepository;

@Service
public class ActorServiceimpl implements ActorService {
    private final ActorJPARepository actorJPARepository;

    public ActorServiceimpl(ActorJPARepository actorJPARepository) {
        this.actorJPARepository = actorJPARepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorJPARepository.findAll();
    }

    @Override
    public Actor findById(Long id) throws ResourceNotFoundException {
        return actorJPARepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor with id=%s not found.".formatted(id)));
    }

    @Override
    public Actor create(Actor actor) {
        return actorJPARepository.save(actor);
    }

    @Override
    public Actor update(Actor actor) {
        return actorJPARepository.save(actor);
    }

    @Override
    public Actor deleteById(Long id) throws ResourceNotFoundException {
        Actor actor = findById(id);
        actorJPARepository.deleteById(id);
        return actor;
    }

    @Override
    public Actor getActorClassProjection() {
        return actorJPARepository.getActorClassProjection();
    }

    @Override
    public ActorProjection getActorInterfaceProjection() {
        return actorJPARepository.getActorInterfaceProjection();
    }
    

}
