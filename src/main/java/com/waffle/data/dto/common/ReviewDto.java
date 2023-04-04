package com.waffle.data.dto.common;

import com.waffle.data.dto.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.dto.response.user.root.UserSlimResponseDto;
import lombok.Data;


/**
 * Review dto.
 */
@Data
public class ReviewDto {

    private Integer rating;
    private String text;

    private UserSlimResponseDto user;
    private VehicleSlimResponseDto vehicle;
}
