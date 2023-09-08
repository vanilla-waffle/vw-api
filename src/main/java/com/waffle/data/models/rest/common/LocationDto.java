package com.waffle.data.models.rest.common;

import com.waffle.data.models.rest.response.city.CityResponseDto;
import lombok.Data;

/**
 * Location dto.
 */
@Data
public class LocationDto {

    private Double latitude;
    private Double longitude;
    private String address;
    private CityResponseDto city;
}
