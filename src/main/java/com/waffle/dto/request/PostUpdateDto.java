package com.waffle.dto.request;

import com.waffle.dto.common.PaymentPlanDto;
import com.waffle.dto.common.PostDto;
import com.waffle.dto.common.SpecificationDto;
import com.waffle.models.constants.types.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

/**
 * Request, dto class to update a Post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostUpdateDto extends PostDto {
    private Long authorId;

    private PaymentPlanDto paymentPlan;
    private SpecificationDto specification;
    private Collection<Feature> features;
}
