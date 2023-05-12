package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.vehicle.VehicleStatus;
import com.waffle.data.models.rest.response.media.ImageResponseDto;
import lombok.Data;

import java.util.List;

/**
 * Common class for dto classes of Post.
 */
@Data
public class VehicleDto {

    private VehicleStatus status;

    private String title;
    private String description;
    private String manuf;
    private String model;
    private Integer releaseYear;

    private List<ImageResponseDto> images;
}
