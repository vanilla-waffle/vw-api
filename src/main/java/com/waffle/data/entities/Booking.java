package com.waffle.data.entities;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.constants.types.vehicle.Payment;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

import static com.waffle.data.constants.types.vehicle.Payment.HOUR;

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

    @Column(nullable = false)
    private LocalDateTime startsAt;
    @Column(nullable = false)
    private LocalDateTime completesAt;

    @Column(nullable = false)
    private Integer duration;

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
        final Payment type = vehicle.getPaymentPlan().getPayment();
        final Duration period = Duration.between(startsAt, completesAt);

        duration = type.equals(HOUR) ? period.toHoursPart() : (int) period.toDaysPart();
        totalPrice = duration * vehicle.getPaymentPlan().getPrice();
        status = BookingStatus.ACTIVE;
    }
}
