package com.waffle.data.models.rest.response.vehicle.root;

import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.models.rest.common.PaymentPlanDto;
import com.waffle.data.models.rest.common.SpecificationDto;
import com.waffle.data.models.rest.common.VehicleDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.LocationResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Response, dto class of Post with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleAllResponseDto extends VehicleDto {
    private Long id;

    private PaymentPlanDto paymentPlan;
    private SpecificationDto spec;
    private Set<Feature> features;
    private UserSlimResponseDto user;
    private LocationResponseDto location;
}
