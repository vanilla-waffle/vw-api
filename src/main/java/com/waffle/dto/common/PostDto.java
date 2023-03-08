package com.waffle.dto.common;

import com.waffle.model.constants.types.Feature;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Common class for dto classes of Post.
 */
public class PostDto {
    private String title;
    private String description;
    private String manufacturer;
    private String model;
    private LocalDate releaseYear;
    private PaymentPlanDto paymentPlan;
    private SpecificationDto specification;
    private Collection<Feature> features;
}
