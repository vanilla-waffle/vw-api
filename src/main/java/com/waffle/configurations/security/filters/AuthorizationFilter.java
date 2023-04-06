package com.waffle.configurations.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.security.jwt.Jwt;
import com.waffle.data.dto.other.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Authorization filter-layer.
 */
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    private void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        if (!requiresAuthentication(request, response)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            Authentication auth = attemptAuthentication(request, response);

            if (auth == null) {
                return;
            }

            successfulAuthentication(request, response, chain, auth);
        } catch (InternalAuthenticationServiceException e) {
            this.logger.error("An internal error occurred while trying to authenticate the user.", e);
            unsuccessfulAuthentication(request, response, e);
        } catch (AuthenticationException e) {
            unsuccessfulAuthentication(request, response, e);
        }
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain chain,
            final Authentication auth) throws IOException, ServletException {
        final UserContext ctx = (UserContext) auth.getPrincipal();

        final String accessToken = Jwt.provider().token(ctx);
        final String refreshToken = Jwt.provider().refreshToken(ctx);

        final Map<String, Object> token = Map.of("access_token", accessToken, "refresh_token", refreshToken);
        final Map<String, Object> data = Map.of("auth", token, "user", ctx);
        final String body = new ObjectMapper().writeValueAsString(data);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.getWriter().write(body);
        response.flushBuffer();
    }

    @Override
    protected boolean requiresAuthentication(final HttpServletRequest request, final HttpServletResponse response) {
        return request.getParameter("username") != null && request.getParameter("password") != null;
    }
}
