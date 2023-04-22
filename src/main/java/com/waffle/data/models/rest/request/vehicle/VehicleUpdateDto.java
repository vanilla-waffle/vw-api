package com.waffle.data.models.rest.request.vehicle;

import com.waffle.data.models.rest.common.PaymentPlanDto;
import com.waffle.data.models.rest.common.SpecificationDto;
import com.waffle.data.models.rest.common.VehicleDto;
import com.waffle.data.constants.types.vehicle.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Request, dto class to update a Post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VehicleUpdateDto extends VehicleDto {

    private Long id;
    private PaymentPlanDto paymentPlan;
    private SpecificationDto specification;
    private Set<Feature> features;
}
