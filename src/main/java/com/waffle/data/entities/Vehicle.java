package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.constants.types.vehicle.VehicleStatus;
import com.waffle.data.entities.behaviour.Persistable;
import com.waffle.data.entities.embedded.vehicle.PaymentPlan;
import com.waffle.data.entities.embedded.vehicle.Specification;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Post entity.
 */
@Entity
@Table(name = "vw_vehicles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BasicEntity implements Persistable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @OneToMany(
            cascade = { CascadeType.REMOVE },
            orphanRemoval = true)
    private List<Image> images;

    @ElementCollection(targetClass = Feature.class)
    @CollectionTable(name = "vw_vehicle_feature", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "feature_name")
    private Set<Feature> features;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private VehiclePassport passport;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Location location;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Review> reviews;

    @Override
    @PrePersist
    public void onPersist() {
        status = VehicleStatus.ACTIVE;
    }
}
