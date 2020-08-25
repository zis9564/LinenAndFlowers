package com.geleigeit.LinenAndFlowers.config;

import com.geleigeit.LinenAndFlowers.config.auditor.AuditorAwareImpl;
import com.geleigeit.LinenAndFlowers.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditorConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
