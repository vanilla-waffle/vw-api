package com.waffle.configurations.security.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.configurations.security.jwt.Jwt;
import com.waffle.data.models.other.AuthenticationResponse;
import com.waffle.data.models.other.ErrorMessageDto;
import com.waffle.data.models.other.JwtPair;
import com.waffle.data.models.other.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Authentication result handler.
 */
@RequiredArgsConstructor
public class AuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    private final ObjectMapper mapper;
    private final Jwt jwt;

    @Override
    public void onAuthenticationSuccess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Authentication authentication) throws IOException {
        final UserContext ctx = (UserContext) authentication.getPrincipal();
        final JwtPair jwts = jwt.pair(ctx);
        final String body = getBody(ctx, jwts);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.getWriter().write(body);
        response.flushBuffer();
    }

    @Override
    public void onAuthenticationFailure(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException failed) throws IOException {
        final String body = getBody(failed);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(SC_UNAUTHORIZED);
        response.getWriter().write(body);
    }

    /**
     * Token refresh success handler.
     *
     * @param request {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @param authentication {@link Authentication}
     * @throws IOException e
     */
    public void onRefreshSuccess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Authentication authentication) throws IOException {
        final UserContext ctx = (UserContext) authentication.getPrincipal();
        final JwtPair jwts = jwt.pair(ctx);
        final String body = getBody(jwts);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.getWriter().write(body);
        response.flushBuffer();
    }

    private String getBody(final UserContext ctx, final JwtPair jwts) throws JsonProcessingException {
        final AuthenticationResponse response = AuthenticationResponse.builder().auth(jwts).user(ctx.data()).build();
        return mapper.writeValueAsString(response);
    }

    private String getBody(final JwtPair jwts) throws JsonProcessingException {
        return mapper.writeValueAsString(jwts);
    }

    private String getBody(final AuthenticationException e) throws JsonProcessingException {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .reason(e.getClass().getSimpleName())
                .code(UNAUTHORIZED)
                .message(e.getMessage())
                .build();
        return mapper.writeValueAsString(message);
    }
}
