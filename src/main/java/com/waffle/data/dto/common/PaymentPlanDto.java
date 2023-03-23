package com.waffle.data.dto.common;

import com.waffle.data.constants.types.vehicle.Payment;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Common class for dto classes of Payment.
 */
@Data
public class PaymentPlanDto {

    @NotEmpty
    @Positive
    private Long price;

    @NotNull
    private Payment payment;
}
