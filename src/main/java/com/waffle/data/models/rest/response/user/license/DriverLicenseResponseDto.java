package com.waffle.data.models.rest.response.user.license;

import com.waffle.data.models.rest.common.DriverLicenseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Driver license response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DriverLicenseResponseDto extends DriverLicenseDto {
    private Long id;
}
