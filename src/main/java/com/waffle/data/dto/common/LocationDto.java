package com.waffle.data.dto.common;

import com.waffle.data.constants.types.common.City;
import lombok.Data;

/**
 * Location dto.
 */
@Data
public class LocationDto {

    private City city;
    private String address;

    private Double latitude;
    private Double longitude;
}
