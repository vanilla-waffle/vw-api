package com.waffle.model.entity;

import com.waffle.model.constants.embedded.PaymentPlan;
import com.waffle.model.constants.embedded.Specification;
import com.waffle.model.constants.types.Feature;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate releaseYear;

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
