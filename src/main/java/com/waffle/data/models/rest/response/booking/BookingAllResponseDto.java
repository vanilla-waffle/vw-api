package com.waffle.data.models.rest.response.booking;

import com.waffle.data.models.rest.common.BookingDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Booking response dto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BookingAllResponseDto extends BookingDto {

    private Long id;
    private LocalDateTime createdAt;

    private UserSlimResponseDto user;
    private VehicleSlimResponseDto vehicle;
}

