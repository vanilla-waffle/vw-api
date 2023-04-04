package com.waffle.data.dto.response.user;

import com.waffle.data.dto.common.BookingDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Booking response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookingResponseDto extends BookingDto {

    private Long id;
    private LocalDateTime createdAt;
}
