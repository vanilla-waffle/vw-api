package com.waffle.dto.request;

import com.waffle.dto.common.ProfileDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request, dto class to create a Profile.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfileCreateDto extends ProfileDto {
    private String password;
}
