package com.mansour.lombok.shared.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity<I> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;
}
