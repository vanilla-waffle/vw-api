package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.vehicle.*;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Common class for dto classes of Specification.
 */
@Data
public class SpecificationDto {

    @NotNull
    private Color color;

    @NotNull
    private Body body;

    @NotNull
    private Drive drive;

    @NotNull
    private Transmission transmission;

    @NotNull
    private Fuel fuel;

    @NotNull
    @Positive
    private Double engineVolume;

    @NotNull
    @Min(2)
    private Integer doors;

    @NotNull
    @Min(2)
    private Integer seats;
}
