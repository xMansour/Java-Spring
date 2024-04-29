package com.mansour.security.entity;

import java.util.Set;

import com.mansour.security.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "security_user")
public class AppUser extends BaseEntity {
    private String name;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // without it the following exception will be thrown when
                                         // UserServiceImpl#getAuthorities() try to call getRoles()
                                         // org.hibernate.LazyInitializationException: failed to lazily initialize a
                                         // collection of role: com.mansour.security.entity.AppUser.roles: could not
                                         // initialize proxy - no Session
    @JoinTable(name = "security_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public AppUser() {
    }

    public AppUser(String name, String userName, String password, Set<Role> roles) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
