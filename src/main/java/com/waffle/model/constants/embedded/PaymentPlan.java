package com.waffle.model.constants.embedded;

import com.waffle.model.constants.types.Payment;
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
    private Payment type;
}
