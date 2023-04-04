package com.waffle.data.dto.response.user;

import com.waffle.data.dto.common.ReviewDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Review response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewResponseDto extends ReviewDto {

    private Long id;
    private LocalDateTime createdAt;
}
