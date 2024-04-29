package com.mansour.auditing.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // If using spring security
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();
        // if (authentication == null || !authentication.isAuthenticated()) {
        // return null;
        // }

        // return ((MyUserDetails) authentication.getPrincipal()).getUser();

        return Optional.of("New User");

    }

}
