package com.waffle.data.dto.common;

import com.waffle.data.dto.response.vehicle.VehicleSlimDto;
import com.waffle.data.dto.response.user.UserSlimDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Review dto.
 */
@Data
public class ReviewDto {

    private Long id;
    private LocalDateTime createdAt;

    private Integer rating;
    private String text;

    private UserSlimDto user;
    private VehicleSlimDto vehicle;
}
