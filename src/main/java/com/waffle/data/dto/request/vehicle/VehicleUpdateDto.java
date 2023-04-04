package com.waffle.data.dto.request.vehicle;

import com.waffle.data.dto.common.PaymentPlanDto;
import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.common.SpecificationDto;
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
