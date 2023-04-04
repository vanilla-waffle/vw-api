package com.waffle.data.dto.request.user;

import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.dto.common.base.ProfileDto;
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
