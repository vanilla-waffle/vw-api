package com.waffle.mappers;

import com.waffle.dto.PaymentPlanDto;
import com.waffle.dto.PostDto;
import com.waffle.dto.SpecificationDto;
import com.waffle.models.embedded.PaymentPlan;
import com.waffle.models.embedded.Specification;
import com.waffle.models.entity.Post;
import org.springframework.stereotype.Component;

/**
 * Post-DTO mapper.
 */
@Component
public class PostMapper {

    /**
     * Map from {@link com.waffle.dto.PostDto.Request.Create} to {@link Post}.
     *
     * @param source post create dto
     * @return post entity
     */
    public Post createdToPost(final PostDto.Request.Create source) {
        if (source == null) {
            return new Post();
        }

        PaymentPlanDto.Request.Create plan = source.getPaymentPlan();
        SpecificationDto.Request.Create specs = source.getSpecification();

        return Post.builder()
                .title(source.getTitle())
                .description(source.getDescription())
                .features(source.getFeatures())
                .title(source.getTitle())
                .model(source.getModel())
                .manufacturer(source.getManufacturer())
                .releaseYear(source.getReleaseYear())
                .model(source.getModel())
                .paymentPlan(
                        PaymentPlan.builder()
                                .price(plan.getPrice())
                                .type(plan.getPayment())
                                .build()
                )
                .specification(
                        Specification.builder()
                                .body(specs.getBody())
                                .color(specs.getColor())
                                .doors(specs.getDoors())
                                .drive(specs.getDrive())
                                .engineVolume(specs.getEngineVolume())
                                .fuel(specs.getFuel())
                                .seats(specs.getSeats())
                                .transmission(specs.getTransmission())
                                .build()
                )
                .build();
    }
}
