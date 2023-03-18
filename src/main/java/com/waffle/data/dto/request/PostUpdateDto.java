package com.waffle.data.dto.request;

import com.waffle.data.dto.common.PaymentPlanDto;
import com.waffle.data.dto.common.PostDto;
import com.waffle.data.dto.common.SpecificationDto;
import com.waffle.data.constants.types.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

/**
 * Request, dto class to update a Post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostUpdateDto extends PostDto {

    private PaymentPlanDto paymentPlan;
    private SpecificationDto specification;
    private Collection<Feature> features;
}
