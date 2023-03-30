package com.waffle.data.dto.response.user;

import com.waffle.data.dto.common.base.UserDto;
import com.waffle.data.dto.response.user.profile.ProfileSlimDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of User with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserSlimDto extends UserDto {

    private ProfileSlimDto profile;
}
