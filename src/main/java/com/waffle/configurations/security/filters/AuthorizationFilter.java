package com.waffle.configurations.security.filters;

import com.waffle.configurations.security.handlers.AuthorizationFailedHandler;
import com.waffle.configurations.security.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authorization filter.
 */
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {
    private final AuthorizationFailedHandler authorizationFailedHandler;
    private final Jwt jwt;

    @Override
    protected void doFilterInternal(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final FilterChain chain) throws ServletException, IOException {
        final String token = Jwt.utils().getTokenFromRequestHeader(request);

        if (token == null) {
            chain.doFilter(request, response);
            return;
        }

        try {
            if (!jwt.provider().valid(token)) {
                throw new AccessDeniedException("Access denied. Authentication is required.");
            }

            final UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) jwt.provider().auth(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            chain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            authorizationFailedHandler.handle(request, response, e);
        }
    }
}
