package com.waffle.data.models.rest.response.user.review;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.ReviewDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Review response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt" })
public class ReviewResponseDto extends ReviewDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
