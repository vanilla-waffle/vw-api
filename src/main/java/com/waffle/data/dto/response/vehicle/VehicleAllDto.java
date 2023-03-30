package com.waffle.data.dto.response.vehicle;

import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.dto.common.*;
import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.response.user.UserSlimDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.List;

/**
 * Response, dto class of Post with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleAllDto extends VehicleDto {

    private PaymentPlanDto paymentPlan;
    private SpecificationDto spec;
    private Collection<Feature> features;
    private UserSlimDto user;
    private LocationDto location;
    private List<ReviewDto> reviews;
}
