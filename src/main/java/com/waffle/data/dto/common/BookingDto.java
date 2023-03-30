package com.waffle.data.dto.common;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.dto.response.vehicle.VehicleSlimDto;
import com.waffle.data.dto.response.user.UserSlimDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Booking dto.
 */
@Data
public class BookingDto {

    private Long id;
    private LocalDateTime createdAt;

    private UserSlimDto user;
    private VehicleSlimDto vehicle;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    private Double totalPrice;

    private BookingStatus status;
}
