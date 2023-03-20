package com.waffle.data.entity;

import com.waffle.data.constants.types.vehicle.Feature;
import com.waffle.data.embedded.PaymentPlan;
import com.waffle.data.embedded.Specification;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

/**
 * Post entity.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String manufacturer;
    private String model;
    private Integer releaseYear;

    @Embedded
    private PaymentPlan paymentPlan;

    @Embedded
    private Specification specification;

    @ElementCollection(targetClass = Feature.class)
    @CollectionTable(name = "post_feature", joinColumns = @JoinColumn(name = "post_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "feature_name")
    private Collection<Feature> features;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
