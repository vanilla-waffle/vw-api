package com.waffle.configurations.security.entries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Entry point for handling authentication-related errors.
 */
@Component
public class AuthenticationErrorHandlerEntryPoint implements AuthenticationEntryPoint {
    private final HandlerExceptionResolver resolver;

    /**
     * Constructor with required arguments.
     *
     * @param resolver {@link HandlerExceptionResolver}
     */
    public AuthenticationErrorHandlerEntryPoint(
            @Autowired @Qualifier("handlerExceptionResolver") final HandlerExceptionResolver resolver
    ) {
        this.resolver = resolver;
    }

    @Override
    public void commence(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException authException) throws IOException, ServletException {
        resolver.resolveException(request, response, null, authException);
    }
}
