package com.waffle.data.dto.common.base;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * Common class for dto classes of Post.
 */
@Data
public class VehicleDto {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String manuf;
    @NotEmpty
    private String model;

    @NotEmpty
    @Positive
    private Integer releaseYear;
}
