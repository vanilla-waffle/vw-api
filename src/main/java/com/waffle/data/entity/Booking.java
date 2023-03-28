package com.waffle.data.entity;

import com.waffle.data.constants.types.booking.BookingStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Booking entity.
 */
@Entity
@Table(name = "bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @Column(nullable = false)
    private User user;
    @ManyToOne
    @Column(nullable = false)
    private Vehicle vehicle;

    private LocalDateTime start;
    private LocalDateTime end;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;
}
