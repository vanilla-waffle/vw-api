package com.waffle.data.models.rest.response.vehicle.root;

import com.waffle.data.models.rest.common.root.VehicleDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.location.LocationResponseDto;
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
