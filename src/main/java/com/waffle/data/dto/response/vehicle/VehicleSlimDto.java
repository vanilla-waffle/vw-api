package com.waffle.data.dto.response.vehicle;

import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.entities.Location;
import com.waffle.data.entities.User;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of Post with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleSlimDto extends VehicleDto {

    private PaymentPlan paymentPlan;
    private User user;
    private Location location;
}
