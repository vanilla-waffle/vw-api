package com.waffle.data.dto.other;

import lombok.Builder;
import lombok.Data;

/**
 * Error message dto.
 */
@Data
@Builder
public class ErrorMessageDto {
    private String reason;
    private String message;
}
