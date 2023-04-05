package com.waffle.configurations.security;

import com.waffle.configurations.security.entries.AuthenticationErrorHandlerEntryPoint;
import com.waffle.configurations.security.filters.AuthenticationFilter;
import com.waffle.configurations.security.filters.AuthorizationFilter;
import com.waffle.services.composite.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * Security configuration.
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationErrorHandlerEntryPoint errorHandlerEntryPoint;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .csrf().disable()
                .anonymous().disable()
                .cors().disable()
                .exceptionHandling().authenticationEntryPoint(errorHandlerEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new AuthorizationFilter(authenticationManagerBean()));
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider()
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Password encoder bean.
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static class BasicRequestMatcher implements RequestMatcher {

        @Override
        public boolean matches(final HttpServletRequest request) {
            final String auth = request.getHeader("Authorization");
            return auth != null && auth.startsWith("Basic");
        }
    }
}
