package com.waffle.data.dto.common;

import lombok.Data;

/**
 * Payment method dto.
 */
@Data
public class PaymentMethodDto {

    private String name;
    private String number;
    private String expireAt;
}
