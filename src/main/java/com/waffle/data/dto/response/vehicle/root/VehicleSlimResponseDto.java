package com.waffle.data.dto.response.vehicle.root;

import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.response.user.root.UserSlimResponseDto;
import com.waffle.data.dto.response.vehicle.LocationResponseDto;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Response, dto class of Post with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleSlimResponseDto extends VehicleDto {

    private Long id;
    private LocalDateTime createdAt;

    private PaymentPlan paymentPlan;
    private UserSlimResponseDto user;
    private LocationResponseDto location;
}
