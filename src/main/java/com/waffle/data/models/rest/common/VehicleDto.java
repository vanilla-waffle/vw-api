package com.waffle.data.models.rest.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Common class for dto classes of Post.
 */
@Data
public class VehicleDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String manuf;
    @NotEmpty
    private String model;

    @NotNull
    @Positive
    private Integer releaseYear;

    @NotNull
    private VehiclePassportDto passport;
}
