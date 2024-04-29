package com.mansour.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mansour.security.entity.AppUser;
import com.mansour.security.repository.UserJPARepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserJPARepository userJPARepository;

    public UserDetailsServiceImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userJPARepository.findByUserName(username);
        if (!appUser.isPresent())
            throw new UsernameNotFoundException("User with user name: %s isn't found.".formatted(username));

        return new User(appUser.get().getUserName(), appUser.get().getPassword(), getAuthorities(appUser.get()));

    }

    private List<GrantedAuthority> getAuthorities(AppUser appUser) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (!appUser.getRoles().isEmpty()) {
            appUser.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
        }
        return grantedAuthorities;
    }
}
