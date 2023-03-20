package com.waffle.data.dto.request;

import com.waffle.data.dto.common.PaymentPlanDto;
import com.waffle.data.dto.common.PostDto;
import com.waffle.data.dto.common.SpecificationDto;
import com.waffle.data.constants.types.vehicle.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

/**
 * Request, dto class to create a Post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostCreateDto extends PostDto {
    private Long authorId;
    private PaymentPlanDto paymentPlan;
    private SpecificationDto specification;
    private Collection<Feature> features;
}
