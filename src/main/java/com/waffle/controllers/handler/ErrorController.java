package com.waffle.controllers.handler;

import com.waffle.data.dto.other.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;

/**
 * Exceptions handler.
 */
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            @NonNull final MissingServletRequestParameterException ex,
            @NonNull final HttpHeaders headers,
            @NonNull final HttpStatus status,
            @NonNull final WebRequest request) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(ex.getClass().getName())
                .message(ex.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull final MethodArgumentNotValidException ex,
            @NonNull final HttpHeaders headers,
            @NonNull final HttpStatus status,
            @NonNull final WebRequest request) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(ex.getClass().getName())
                .message(ex.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    /**
     * Handles IllegalArgumentException.
     *
     * @param e exception
     * @return error message dto
     */
    @ExceptionHandler(value = { IllegalArgumentException.class, ConstraintViolationException.class })
    ResponseEntity<ErrorMessageDto> handle(final RuntimeException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getName())
                .message(e.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    /**
     * Handles IllegalArgumentException.
     *
     * @param e exception
     * @return error message dto
     */
    @ExceptionHandler(value = { Exception.class })
    ResponseEntity<ErrorMessageDto> handle(final Exception e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(INTERNAL_SERVER_ERROR)
                .reason(e.getClass().toString())
                .message(e.getMessage())
                .build();
        return status(INTERNAL_SERVER_ERROR).body(message);
    }
}
