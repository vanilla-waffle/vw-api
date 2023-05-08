package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.vehicle.VehicleStatus;
import lombok.Data;

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
}
