package com.waffle.data.dto.response.user;

import com.waffle.data.dto.common.PaymentMethodDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Payment method response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodResponseDto extends PaymentMethodDto {

    private Long id;
    private LocalDate createdAt;
}
