package com.waffle.data.dto.common;

import com.waffle.data.constants.types.common.City;

import java.time.LocalDateTime;

/**
 * Location dto.
 */
public class LocationDto {

    private Long id;
    private LocalDateTime createdAt;

    private City city;
    private String address;

    private Double latitude;
    private Double longitue;
}
