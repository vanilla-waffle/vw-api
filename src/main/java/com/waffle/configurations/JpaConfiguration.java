package com.waffle.configurations;

import com.waffle.data.repositories.impl.FilteredJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Jpa configuration.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.waffle.data.repositories",
        repositoryBaseClass = FilteredJpaRepositoryImpl.class
)
public class JpaConfiguration {
}
