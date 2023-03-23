package com.waffle.data.dto.common;

import com.waffle.data.constants.types.common.City;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Common class for dto classes of Profile.
 */
@Data
public class ProfileDto {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private City city;
}
