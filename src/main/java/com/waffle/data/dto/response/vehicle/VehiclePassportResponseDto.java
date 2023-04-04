package com.waffle.data.dto.response.vehicle;

import com.waffle.data.dto.common.VehiclePassportDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Vehicle passport all dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehiclePassportResponseDto extends VehiclePassportDto {

    private Long id;
    private LocalDateTime createdAt;
}

