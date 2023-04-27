package com.waffle.controllers.handler;

import com.waffle.data.constants.exceptions.UserAlreadyExistsException;
import com.waffle.data.constants.exceptions.NotFoundException;
import com.waffle.data.constants.exceptions.VehicleNotFoundException;
import com.waffle.data.models.other.ErrorMessageDto;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

/**
 * Exceptions handler.
 */
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleTypeMismatch(
            @NonNull final TypeMismatchException ex,
            @NonNull final HttpHeaders headers,
            @NonNull final HttpStatus status,
            @NonNull final WebRequest request) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            @NonNull final MissingServletRequestParameterException ex,
            @NonNull final HttpHeaders headers,
            @NonNull final HttpStatus status,
            @NonNull final WebRequest request) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(ex.getClass().getSimpleName())
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
                .reason(ex.getClass().getSimpleName())
                .message(
                        ex.getBindingResult().getFieldErrors().stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining(","))
                )
                .build();
        return status(BAD_REQUEST).body(message);
    }

    /**
     * Handles not-found exceptions.
     *
     * @param e exception
     * @return error message dto
     */
    @ExceptionHandler(value = { NotFoundException.class, VehicleNotFoundException.class })
    ResponseEntity<ErrorMessageDto> handle(final NotFoundException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(NOT_FOUND)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(NOT_FOUND).body(message);
    }

    /**
     * Handles IllegalArgumentException.
     *
     * @param e exception
     * @return error message dto
     */
    @ExceptionHandler(value = { ConstraintViolationException.class, UserAlreadyExistsException.class })
    ResponseEntity<ErrorMessageDto> handle(final RuntimeException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getSimpleName())
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
    @ExceptionHandler(value = { IllegalArgumentException.class })
    ResponseEntity<ErrorMessageDto> handle(final IllegalArgumentException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    /**
     * Handles internal error exceptions.
     *
     * @param e exception
     * @return error message dto
     */
    @ExceptionHandler(value = { Exception.class })
    ResponseEntity<ErrorMessageDto> handle(final Exception e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(INTERNAL_SERVER_ERROR)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(INTERNAL_SERVER_ERROR).body(message);
    }
}
