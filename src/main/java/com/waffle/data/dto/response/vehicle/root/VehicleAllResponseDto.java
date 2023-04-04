package com.waffle.data.dto.response.vehicle.root;

import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.dto.common.*;
import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.response.user.root.UserSlimResponseDto;
import com.waffle.data.dto.response.vehicle.LocationResponseDto;
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
