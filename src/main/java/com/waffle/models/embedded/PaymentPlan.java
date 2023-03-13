package com.waffle.models.embedded;

import com.waffle.models.constants.types.Payment;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Embedded PaymentPlan class for Post entity.
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlan {

    private Long price;

    @Enumerated(EnumType.STRING)
    private Payment payment;
}
