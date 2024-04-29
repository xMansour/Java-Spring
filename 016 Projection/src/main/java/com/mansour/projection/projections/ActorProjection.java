package com.mansour.projection.projections;

import org.springframework.beans.factory.annotation.Value;

public interface ActorProjection {
    String getFirstName();

    String getLastName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

}
