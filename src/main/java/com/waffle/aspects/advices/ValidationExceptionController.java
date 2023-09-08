package com.waffle.aspects.advices;

import com.waffle.data.models.other.ErrorMessageDto;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.Order;
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
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
@Order(0)
public class ValidationExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<ErrorMessageDto> handle(final ConstraintViolationException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    @ExceptionHandler(value = { MaxUploadSizeExceededException.class })
    protected ResponseEntity<ErrorMessageDto> handle(final MaxUploadSizeExceededException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

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
}
