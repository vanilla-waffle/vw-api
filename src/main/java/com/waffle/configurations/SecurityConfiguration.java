package com.waffle.configurations;

import com.waffle.configurations.properties.CookieSettings;
import com.waffle.configurations.properties.SecuritySettings;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration.
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final SecuritySettings securitySettings;
    private final CookieSettings cookieSettings;

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
                .rememberMe(me -> me
                        .tokenValiditySeconds(cookieSettings.expiresAfter())
                        .rememberMeCookieName(cookieSettings.issuer())
                        .key(cookieSettings.secret())
                        .alwaysRemember(cookieSettings.alwaysRemember())
                )
                .sessionManagement(s -> s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(b -> b
                        .realmName(cookieSettings.issuer() + "-realm")
                )
                .cors().and()
                .formLogin().disable()
                .anonymous().disable()
                .csrf().disable()
                .build();
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
