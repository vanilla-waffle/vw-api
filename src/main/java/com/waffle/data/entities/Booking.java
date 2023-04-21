package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.booking.BookingStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference(value = "user-bookings")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Vehicle vehicle;

    private LocalDateTime startsAt;
    private LocalDateTime completesAt;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;
}
