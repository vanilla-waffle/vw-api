package com.waffle.data.models.rest.response.moderation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.ModerationDto;
import com.waffle.data.models.rest.response.user.license.DriverLicenseResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * User moderation all response.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt" })
public class UserModerationAllResponseDto extends ModerationDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DriverLicenseResponseDto license;
}
