package com.waffle.data.dto.other;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Error message dto.
 */
@Data
@Builder
public class ErrorMessageDto {
    private HttpStatus code;
    private String reason;
    private String message;
}
