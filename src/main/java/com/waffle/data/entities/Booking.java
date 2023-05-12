package com.waffle.data.entities;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.constants.types.vehicle.Payment;
import com.waffle.data.entities.behaviour.Persistable;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.waffle.data.constants.types.vehicle.Payment.HOUR;

@Entity
@Table(name = "vw_bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Booking extends BasicEntity implements Persistable {

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

    @Override
    @PrePersist
    public void onPersist() {
        final double price = vehicle.getPaymentPlan().getPrice();
        final Payment type = vehicle.getPaymentPlan().getPayment();
        final Duration period = Duration.between(startsAt, completesAt);

        duration = type.equals(HOUR) ? (int) period.toHours() : (int) period.toDays();
        totalPrice = duration * price;
        status = BookingStatus.PENDING;
    }

    /**
     * Check whether booking overlaps with another list of bookings or not.
     *
     * @param bookings {@link List<Booking>}
     * @return {@code boolean}
     */
    public boolean overlaps(final List<Booking> bookings) {
        return bookings.stream()
                .filter(b -> b.status.equals(BookingStatus.ACTIVE))
                .anyMatch(this::overlaps);
    }

    /**
     * Check whether booking overlaps with another or not.
     *
     * @param another {@link Booking}
     * @return {@code boolean}
     */
    public boolean overlaps(final Booking another) {
        return startsAt.isBefore(another.completesAt)
                && another.startsAt.isBefore(completesAt);
    }
}
