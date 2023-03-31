package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Payment method entities.
 */
@Entity
@Table(name = "vw_payment_methods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;

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
