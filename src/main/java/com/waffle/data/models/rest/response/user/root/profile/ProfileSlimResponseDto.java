package com.waffle.data.models.rest.response.user.root.profile;

import com.waffle.data.models.rest.common.DriverLicenseDto;
import com.waffle.data.models.rest.common.root.ProfileDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Profile slim dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileSlimResponseDto extends ProfileDto {

    private String email;
    private String phoneNumber;

    private DriverLicenseDto driverLicense;
}
