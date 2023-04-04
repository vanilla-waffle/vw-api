package com.waffle.data.dto.response.user.root;

import com.waffle.data.dto.common.DriverLicenseDto;
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
