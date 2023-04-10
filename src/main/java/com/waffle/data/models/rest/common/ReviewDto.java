package com.waffle.data.models.rest.common;

import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
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
