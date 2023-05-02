package com.waffle.data.models.rest.common;

import lombok.Data;

/**
 * Common class for dto classes of Post.
 */
@Data
public class VehicleDto {

    private String title;

    private String description;

    private String manuf;
    private String model;

    private Integer releaseYear;
}
