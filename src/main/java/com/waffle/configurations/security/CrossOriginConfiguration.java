package com.waffle.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Cors configuration.
 */
@Configuration
public class CrossOriginConfiguration {
    private static final List<String> ALLOWED_METHODS = List.of("GET", "POST", "PATCH", "DELETE", "PUT", "OPTIONS");
    private static final List<String> ALLOWED_ORIGINS = List.of("*");

    /**
     * Cors configuration source.
     *
     * @return {@link CorsConfigurationSource}
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        configuration.setAllowedOrigins(ALLOWED_ORIGINS);
        configuration.setAllowedMethods(ALLOWED_METHODS);
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
