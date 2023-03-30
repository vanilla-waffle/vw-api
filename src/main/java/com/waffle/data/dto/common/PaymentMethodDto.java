package com.waffle.data.dto.common;

import lombok.Data;

import java.time.LocalDate;

/**
 * Payment method dto.
 */
@Data
public class PaymentMethodDto {

    private Long id;
    private LocalDate createdAt;

    private String name;
    private String number;
    private String expireAt;
}
