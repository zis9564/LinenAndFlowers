package com.geleigeit.LinenAndFlowers.config.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return Optional.of(user.getUsername());
    }
}
