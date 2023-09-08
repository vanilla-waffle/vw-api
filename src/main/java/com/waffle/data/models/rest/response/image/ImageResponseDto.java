package com.waffle.data.models.rest.response.image;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.ImageDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Media response dto.
 */
@Getter
@Setter
@JsonPropertyOrder({ "id", "createdAt" })
public class ImageResponseDto extends ImageDto {

    private Long id;
    private LocalDateTime createdAt;
}
