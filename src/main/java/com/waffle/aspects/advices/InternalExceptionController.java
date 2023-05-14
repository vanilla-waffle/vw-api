package com.waffle.aspects.advices;

import com.waffle.data.models.other.ErrorMessageDto;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
@Order(1)
public class InternalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<ErrorMessageDto> handle(final IllegalArgumentException e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(BAD_REQUEST)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(BAD_REQUEST).body(message);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ErrorMessageDto> handle(final Exception e) {
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(INTERNAL_SERVER_ERROR)
                .reason(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
        return status(INTERNAL_SERVER_ERROR).body(message);
    }
}
