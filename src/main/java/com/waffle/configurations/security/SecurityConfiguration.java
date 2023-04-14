package com.waffle.configurations.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.properties.JwtSettings;
import com.waffle.configurations.properties.SecuritySettings;
import com.waffle.configurations.security.filters.AuthenticationFilter;
import com.waffle.configurations.security.filters.AuthorizationFilter;
import com.waffle.configurations.security.handlers.AuthenticationHandler;
import com.waffle.configurations.security.handlers.AuthorizationFailedHandler;
import com.waffle.configurations.security.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
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
    private final JwtSettings cookieSettings;
    private final ObjectMapper mapper;
    private final Jwt jwt;

    /**
     * Web security bean.
     *
     * @return {@link WebSecurityCustomizer}
     */
    @Bean
    public WebSecurityCustomizer webSecurity()  {
        return securitySettings.enabled()
            ? web -> web
                .ignoring()
                .antMatchers("/public/**")
            : web -> web
                .ignoring()
                .antMatchers("/**");
    }

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
                        .antMatchers("/in/**").authenticated()
                )
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .deleteCookies(cookieSettings.issuer())
                        .clearAuthentication(true)
                )
                .sessionManagement(s -> s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .cors().and()
                .formLogin().disable()
                .anonymous().disable()
                .csrf().disable()
                .addFilterBefore(authorizationFilter(), AuthenticationFilter.class)
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
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
