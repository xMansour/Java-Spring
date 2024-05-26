package com.mansour.lombok.employees;

import com.mansour.lombok.shared.base.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends BaseEntity<Long> {
    private String name;
    private String email;
    private String gender;

}
