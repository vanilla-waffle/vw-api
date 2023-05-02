package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.user.DriverLicenseCategory;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Driver license dto.
 */
@Data
public class DriverLicenseDto {

    private Long id;
    private boolean approved;
    private String licenseNumber;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    private Collection<DriverLicenseCategory> categories;
}
