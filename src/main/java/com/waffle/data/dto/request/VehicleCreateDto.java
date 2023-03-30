package com.waffle.data.dto.request;

import com.waffle.data.dto.common.PaymentPlanDto;
import com.waffle.data.dto.common.base.VehicleDto;
import com.waffle.data.dto.common.SpecificationDto;
import com.waffle.data.constants.types.vehicle.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;

/**
 * Request, dto class to create a Post.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleCreateDto extends VehicleDto {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    private PaymentPlanDto paymentPlan;

    @NotNull
    private SpecificationDto spec;
    private Collection<Feature> features;
}
