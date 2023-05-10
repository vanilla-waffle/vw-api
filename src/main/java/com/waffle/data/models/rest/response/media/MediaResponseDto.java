package com.waffle.data.models.rest.response.media;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.MediaDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Media response dto.
 */
@Getter
@Setter
@JsonPropertyOrder({ "id", "createdAt" })
public class MediaResponseDto extends MediaDto {

    private Long id;
    private LocalDateTime createdAt;
}
