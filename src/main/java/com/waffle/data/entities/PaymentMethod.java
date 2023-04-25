package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.common.TextSize;
import lombok.*;

import javax.persistence.*;

/**
 * Payment method entities.
 */
@Entity
@Table(name = "vw_payment_methods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentMethod extends BaseEntity {

    @Column(length = TextSize.S)
    private String name;
    @Column(nullable = false, length = TextSize.XS)
    private String number;
    @Column(nullable = false, length = TextSize.XS)
    private String expireAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonBackReference(value = "user-paymentMethods")
    private User user;
}
