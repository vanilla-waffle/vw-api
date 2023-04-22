package com.waffle.data.models.rest.request.user;

import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.models.rest.common.ProfileDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Request, dto class to create a Profile.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfileCreateDto extends ProfileDto {

    @NotEmpty
    @Password
    private String password;
}
