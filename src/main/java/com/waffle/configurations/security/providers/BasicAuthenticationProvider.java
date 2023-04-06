package com.waffle.configurations.security.providers;

import com.waffle.data.dto.other.Credentials;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Basic [username:password] authentication manager.
 */
@RequiredArgsConstructor
public class BasicAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService service;
    private final PasswordEncoder encoder;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final Credentials creds = Credentials.from(authentication);
        final UserDetails user = service.loadUserByUsername(creds.getUsername());

        if (!encoder.matches(creds.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }

        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
