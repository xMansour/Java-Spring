package com.mansour.projection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mansour.projection.entities.Actor;
import com.mansour.projection.projections.ActorProjection;

@Repository
public interface ActorJPARepository extends JpaRepository<Actor, Long> {

    @Query("select new Actor(actor.firstName, actor.lastName) from Actor actor")
    Actor getActorClassProjection();

    @Query(value = "select first_name as firstName, last_name as lastName from actor", nativeQuery = true)
    ActorProjection getActorInterfaceProjection();

}
