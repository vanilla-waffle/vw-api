package com.waffle.data.dto.common;

import com.waffle.data.constants.types.*;
import lombok.Data;

/**
 * Common class for dto classes of Specification.
 */
@Data
public class SpecificationDto {
    private Color color;
    private Body body;
    private Drive drive;
    private Transmission transmission;
    private Fuel fuel;
    private Integer engineVolume;
    private Integer doors;
    private Integer seats;
}
