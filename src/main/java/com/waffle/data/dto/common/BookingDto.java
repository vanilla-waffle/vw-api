package com.waffle.data.dto.common;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.dto.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.dto.response.user.root.UserSlimResponseDto;
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
