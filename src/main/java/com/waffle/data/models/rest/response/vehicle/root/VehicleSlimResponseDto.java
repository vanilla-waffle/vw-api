package com.waffle.data.models.rest.response.vehicle.root;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.VehicleDto;
import com.waffle.data.models.rest.response.vehicle.location.LocationResponseDto;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Response, dto class of Post with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt" })
public class VehicleSlimResponseDto extends VehicleDto {

    private Long id;
    private LocalDateTime createdAt;

    private PaymentPlan paymentPlan;
    private LocationResponseDto location;
}

