package com.waffle.data.dto.common;

import com.waffle.data.constants.types.Payment;
import lombok.Data;

/**
 * Common class for dto classes of Payment.
 */
@Data
public class PaymentPlanDto {
    private Long price;
    private Payment payment;
}
