package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import com.waffle.data.entities.embedded.vehicle.Specification;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Post entity.
 */
@Entity
@Table(name = "vw_vehicles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false, length = TextSize.M)
    private String title;
    @Column(nullable = false, length = TextSize.XXL)
    private String description;
    @Column(nullable = false)
    private String manuf;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer releaseYear;

    @Embedded
    @Column(nullable = false)
    private PaymentPlan paymentPlan;

    @Embedded
    @Column(nullable = false)
    private Specification spec;

    @ElementCollection(targetClass = Feature.class)
    @CollectionTable(name = "vw_vehicle_feature", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "feature_name")
    private Set<Feature> features;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference(value = "user-vehicles")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "vehicle-passport")
    private VehiclePassport passport;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false)
    @JsonManagedReference(value = "vehicle-location")
    private Location location;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "vehicle-reviews")
    private List<Review> reviews;
}
