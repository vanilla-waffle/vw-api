package com.waffle.data.entities.embedded.vehicle;

import com.waffle.data.constants.types.vehicle.Payment;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Embedded PaymentPlan class for Post entity.
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlan {

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Payment payment;
}
