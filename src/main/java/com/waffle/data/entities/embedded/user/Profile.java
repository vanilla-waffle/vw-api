package com.waffle.data.entities.embedded.user;

import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Embedded Profile class for User entity.
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(unique = true, length = TextSize.M)
    private String username;
    @Column(length = TextSize.S)
    private String firstName;
    @Column(length = TextSize.S)
    private String lastName;
    @Column(length = TextSize.M)
    private String phoneNumber;

    @OneToOne(orphanRemoval = true)
    private DriverLicense driverLicense;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private List<PaymentMethod> paymentMethods;
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private List<Vehicle> vehicles;
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private List<Booking> bookings;
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private List<Review> reviews;

    @Enumerated(EnumType.STRING)
    private City city;
}
