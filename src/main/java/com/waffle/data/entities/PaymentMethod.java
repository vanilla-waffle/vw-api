package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.root.BasicEntity;
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
public class PaymentMethod extends BasicEntity {

    @Column(length = TextSize.S)
    private String name;
    @Column(nullable = false, length = TextSize.XS)
    private String number;
    @Column(nullable = false, length = TextSize.XS)
    private String expireAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;
}
