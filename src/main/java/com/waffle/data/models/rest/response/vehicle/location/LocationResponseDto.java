package com.waffle.data.models.rest.response.vehicle.location;

import com.waffle.data.models.rest.common.LocationDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Location response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LocationResponseDto extends LocationDto {

    private Long id;
    private LocalDateTime createdAt;
}


