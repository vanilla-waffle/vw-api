package com.waffle.configurations.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.security.handlers.AuthenticationHandler;
import com.waffle.data.models.other.pair.CredentialsPair;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Authetnication filter.
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper mapper = new ObjectMapper();
    private final AuthenticationHandler authenticationHandler;

    /**
     * Constructor.
     *
     * @param authenticationManager {@link AuthenticationManager}
     * @param authenticationHandler {@link AuthenticationHandler}
     */
    public AuthenticationFilter(
            final AuthenticationManager authenticationManager,
            final AuthenticationHandler authenticationHandler) {
        super(authenticationManager);
        this.authenticationHandler = authenticationHandler;
    }

    @Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    private void doFilter(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        if (!requiresAuthentication(request, response)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            final Authentication auth = attemptAuthentication(request, response);

            if (auth == null) {
                return;
            }

            successfulAuthentication(request, response, chain, auth);
        } catch (AuthenticationException e) {
            unsuccessfulAuthentication(request, response, e);
        }
    }

    @Override
    public Authentication attemptAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response) throws AuthenticationException {
        final CredentialsPair creds = getCredentials(request);
        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword());
        return this.getAuthenticationManager().authenticate(auth);
    }

    @Override
    protected boolean requiresAuthentication(final HttpServletRequest request, final HttpServletResponse response) {
        return request.getMethod().equals("POST")
                && request.getServletPath().contains("/auth/login");
    }

    @Override
    protected void successfulAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain,
            final Authentication auth) throws IOException {
        final SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        ctx.setAuthentication(auth);
        SecurityContextHolder.setContext(ctx);
        authenticationHandler.onAuthenticationSuccess(request, response, auth);
    }

    @Override
    protected void unsuccessfulAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException failed) throws IOException {
        SecurityContextHolder.clearContext();
        authenticationHandler.onAuthenticationFailure(request, response, failed);
    }

    private CredentialsPair getCredentials(final HttpServletRequest request) {
        try (BufferedReader br = request.getReader()) {
            return mapper.readValue(br, CredentialsPair.class);
        } catch (IOException e) {
            throw new AuthenticationCredentialsNotFoundException("Invalid request body");
        }
    }
}
