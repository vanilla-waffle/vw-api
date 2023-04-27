package com.waffle.data.models.rest.response.user.payment;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.PaymentMethodDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Payment method response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt" })
public class PaymentMethodResponseDto extends PaymentMethodDto {

    private Long id;
    private LocalDate createdAt;
}
