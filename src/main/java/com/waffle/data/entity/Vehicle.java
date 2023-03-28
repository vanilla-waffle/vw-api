package com.waffle.data.entity;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.embedded.vehicle.PaymentPlan;
import com.waffle.data.embedded.vehicle.Specification;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Post entity.
 */
@Entity
@Table(name = "vehicles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = TextSize.S)
    private String title;
    @Column(nullable = false, length = TextSize.XL)
    private String desc;
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
    @CollectionTable(name = "vehicle_feature", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "feature_name")
    private Collection<Feature> features;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private User user;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    private Location location;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;
}
