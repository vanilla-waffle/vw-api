package com.waffle.configurations.security.filters;

import com.waffle.configurations.security.jwt.Jwt;
import com.waffle.data.constants.exceptions.AuthenticationFailedException;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authentication filter-layer.
 */
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final FilterChain filterChain) throws ServletException, IOException {
        final String token = Jwt.utils().getTokenFromRequestHeader(request);

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!Jwt.provider().verify(token)) {
            throw new AuthenticationFailedException("Invalid token: " + token);
        }

        final UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) Jwt.provider().authentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}
