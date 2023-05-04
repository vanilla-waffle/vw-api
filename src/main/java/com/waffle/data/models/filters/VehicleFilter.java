package com.waffle.data.models.filters;

import com.waffle.data.constants.types.common.City;
import lombok.Getter;

/**
 * Vehicle filter.
 */
@Getter
public class VehicleFilter extends Filter {

    private String manuf;
    private String model;
    private String releaseYear;
    private double price;
    private City city;
}
