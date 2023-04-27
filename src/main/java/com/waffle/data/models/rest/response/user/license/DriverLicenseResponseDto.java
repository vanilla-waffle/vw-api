package com.waffle.data.models.rest.response.user.license;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.DriverLicenseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Driver license response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt" })
public class DriverLicenseResponseDto extends DriverLicenseDto {

    private Long id;
    private LocalDateTime createdAt;
}
