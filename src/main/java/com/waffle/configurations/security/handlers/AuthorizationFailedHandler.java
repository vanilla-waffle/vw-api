package com.waffle.configurations.security.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.data.models.other.ErrorMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Authorization failed handler.
 */
@RequiredArgsConstructor
public class AuthorizationFailedHandler implements AccessDeniedHandler {
    private final ObjectMapper mapper;

    @Override
    public void handle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AccessDeniedException failed) throws IOException {
        final String body = getBody(failed);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(SC_FORBIDDEN);
        response.getWriter().write(body);
    }

    private String getBody(final AccessDeniedException e) throws JsonProcessingException {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .reason(e.getClass().getSimpleName())
                .code(FORBIDDEN)
                .message(e.getMessage())
                .build();
        return mapper.writeValueAsString(message);
    }
}
