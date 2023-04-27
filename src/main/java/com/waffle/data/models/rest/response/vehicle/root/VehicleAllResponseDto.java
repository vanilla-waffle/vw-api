package com.waffle.data.models.rest.response.vehicle.root;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.models.rest.common.PaymentPlanDto;
import com.waffle.data.models.rest.common.SpecificationDto;
import com.waffle.data.models.rest.common.VehicleDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.location.LocationResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Response, dto class of Post with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt" })
public class VehicleAllResponseDto extends VehicleDto {
    private Long id;
    private LocalDateTime createdAt;

    private PaymentPlanDto paymentPlan;
    private SpecificationDto spec;
    private Set<Feature> features;
    private UserSlimResponseDto user;
    private LocationResponseDto location;
}
