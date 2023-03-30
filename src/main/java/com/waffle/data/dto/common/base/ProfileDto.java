package com.waffle.data.dto.common.base;

import com.waffle.data.constants.annotations.validation.Phone;
import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.dto.common.DriverLicenseDto;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Common class for dto classes of Profile.
 */
@Data
public class ProfileDto {

    @Email
    private String email;

    @NotEmpty
    @Length(max = TextSize.XS)
    private String username;
    @NotEmpty
    @Length(max = TextSize.XS)
    private String firstName;
    @NotEmpty
    @Length(max = TextSize.XS)
    private String lastName;
    @NotEmpty
    @Phone
    private String phoneNumber;

    private DriverLicenseDto driverLicense;
    private City city;
}
