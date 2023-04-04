package com.waffle.data.dto.response.vehicle.root;

import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.response.user.root.UserSlimResponseDto;
import com.waffle.data.dto.response.vehicle.LocationResponseDto;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of Post with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleSlimResponseDto extends VehicleDto {

    private Long id;
    private PaymentPlan paymentPlan;
    private UserSlimResponseDto user;
    private LocationResponseDto location;
}
