package com.mansour.thymeleaf.author;


import com.mansour.thymeleaf.shared.base.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Author extends BaseEntity<Long> {
    private String name;
}
