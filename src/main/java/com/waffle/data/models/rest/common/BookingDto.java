package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.booking.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Booking dto.
 */
@Data
public class BookingDto {

    private LocalDateTime startsAt;
    private LocalDateTime completesAt;

    private Double totalPrice;

    private BookingStatus status;
}
