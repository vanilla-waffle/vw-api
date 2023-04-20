package com.waffle.configurations.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.security.handlers.AuthenticationHandler;
import com.waffle.configurations.security.jwt.Jwt;
import com.waffle.data.models.other.UserContext;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt refresh filter.
 */
public class JwtRefreshFilter extends OncePerRequestFilter {
    private final AuthenticationHandler authenticationHandler;
    private final UserDetailsService userDetailsService;
    private final Jwt jwt;

    /**
     * Constructor.
     *
     * @param jwt {@link Jwt}
     * @param objectMapper {@link ObjectMapper}
     * @param userDetailsService {@link UserDetailsService}
     */
    public JwtRefreshFilter(final Jwt jwt, final ObjectMapper objectMapper, final UserDetailsService userDetailsService) {
        this.jwt = jwt;
        this.userDetailsService = userDetailsService;
        this.authenticationHandler = new AuthenticationHandler(objectMapper, jwt);
    }

    @Override
    protected void doFilterInternal(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final FilterChain chain) throws ServletException, IOException {
        if (!requiresRefresh(request)) {
            chain.doFilter(request, response);
            return;
        }

        final String token = Jwt.utils().getTokenFromRequestHeader(request);

        final String username = jwt.provider().claim(token, "sub");
        final UserContext ctx = (UserContext) userDetailsService.loadUserByUsername(username);
        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(ctx, null);
        authenticationHandler.onRefreshSuccess(request, response, auth);
    }

    private boolean requiresRefresh(final HttpServletRequest request) {
        return request.getServletPath().contains("auth/refresh")
                && request.getMethod().equals("POST")
                && request.getHeader("Authorization") != null;
    }
}
