package com.waffle.data.models.rest.response.booking;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.BookingDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Booking response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id, createdAt", "updatedAt" })
public class BookingAllResponseDto extends BookingDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserSlimResponseDto user;
    private UserSlimResponseDto owner;
    private VehicleSlimResponseDto vehicle;
}

