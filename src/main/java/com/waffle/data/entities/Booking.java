package com.waffle.data.entities;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.constants.types.vehicle.Payment;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Booking entity.
 */
@Entity
@Table(name = "vw_bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Booking extends BasicEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Vehicle vehicle;

    private LocalDateTime startsAt;
    private LocalDateTime completesAt;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    /**
     * Listener function that gets executed on insert/persist operation.
     */
    @PrePersist
    public void onPersist() {
        long duration;

        if (vehicle.getPaymentPlan().getPayment().equals(Payment.HOUR)) {
            duration = Duration.between(startsAt, completesAt).toHoursPart();
        } else {
            duration = Duration.between(startsAt, completesAt).toDaysPart();
        }

        totalPrice = duration * vehicle.getPaymentPlan().getPrice();
        status = BookingStatus.ACTIVE;
    }
}
