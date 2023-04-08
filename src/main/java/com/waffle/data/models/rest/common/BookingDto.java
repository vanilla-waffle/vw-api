package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Booking dto.
 */
@Data
public class BookingDto {

    private UserSlimResponseDto user;
    private VehicleSlimResponseDto vehicle;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    private Double totalPrice;

    private BookingStatus status;
}
