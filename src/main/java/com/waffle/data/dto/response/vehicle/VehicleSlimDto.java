package com.waffle.data.dto.response.vehicle;

import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.entity.Location;
import com.waffle.data.entity.User;
import com.waffle.data.entity.embedded.vehicle.PaymentPlan;
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
