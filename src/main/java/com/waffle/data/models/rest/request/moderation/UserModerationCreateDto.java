package com.waffle.data.models.rest.request.moderation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.request.license.DriverLicenseCreateDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * User moderation create dto.
 */
@Data
public class UserModerationCreateDto {

    @JsonIgnore
    private Long userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private DriverLicenseCreateDto license;
}
