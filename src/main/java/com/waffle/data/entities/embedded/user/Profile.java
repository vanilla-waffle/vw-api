package com.waffle.data.entities.embedded.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(unique = true, length = TextSize.XS)
    private String username;
    @Column(length = TextSize.S)
    private String firstName;
    @Column(length = TextSize.S)
    private String lastName;
    @Column(length = TextSize.XS)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "user-driverLicense")
    private DriverLicense driverLicense;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-paymentMethods")
    private List<PaymentMethod> paymentMethods;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-vehicles")
    private List<Vehicle> vehicles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-bookings")
    private List<Booking> bookings;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-reviews")
    private List<Review> reviews;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;
}
