package com.waffle.data.dto.response.vehicle;

import com.waffle.data.dto.common.LocationDto;
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


