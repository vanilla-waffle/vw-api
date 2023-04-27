package com.waffle.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.properties.SecuritySettings;
import com.waffle.configurations.security.filters.AuthenticationFilter;
import com.waffle.configurations.security.filters.AuthorizationFilter;
import com.waffle.configurations.security.filters.JwtRefreshFilter;
import com.waffle.configurations.security.handlers.AuthenticationHandler;
import com.waffle.configurations.security.handlers.AuthorizationFailedHandler;
import com.waffle.configurations.security.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security configuration.
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationConfiguration authenticationConfiguration;
    private final SecuritySettings securitySettings;
    private final UserDetailsService userDetailsService;
    private final ObjectMapper mapper;
    private final Jwt jwt;

    /**
     * Filter chain bean.
     *
     * @param http {@link HttpSecurity}
     * @return {@link SecurityFilterChain}
     * @throws Exception exception
     */
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> auth
                        .antMatchers("*/public/**", "*/auth/**").permitAll()
                        .antMatchers("/admin/**").hasAnyAuthority("SUPERADMIN", "ADMIN")
                        .antMatchers("/in/**").authenticated()
                )
                .sessionManagement(s -> s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .cors().and()
                .formLogin().disable()
                .anonymous().disable()
                .csrf().disable()
                .addFilterBefore(authorizationFilter(), AuthenticationFilter.class)
                .addFilterBefore(jwtRefreshFilter(), AuthenticationFilter.class)
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    /**
     * Jwt refresh filter bean.
     *
     * @return {@link JwtRefreshFilter}
     */
    @Bean
    public JwtRefreshFilter jwtRefreshFilter() {
        return new JwtRefreshFilter(jwt, mapper, userDetailsService);
    }

    /**
     * Authorization filter bean.
     *
     * @return {@link AuthorizationFilter}
     */
    @Bean
    public AuthorizationFilter authorizationFilter() {
        return new AuthorizationFilter(new AuthorizationFailedHandler(mapper), jwt);
    }

    /**
     * Authentication filter bean.
     *
     * @return {@link AuthenticationFilter}
     * @throws Exception exception
     */
    @Bean
    public AuthenticationFilter authenticationFilter() throws Exception {
        return new AuthenticationFilter(authenticationManager(), new AuthenticationHandler(mapper, jwt));
    }

    /**
     * Authentication manager bean.
     *
     * @return {@link AuthenticationManager}
     * @throws Exception exception
     */
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Password encoder bean.
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(securitySettings.encoderStrength());
    }
}
