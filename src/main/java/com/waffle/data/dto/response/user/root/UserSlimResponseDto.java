package com.waffle.data.dto.response.user.root;

import com.waffle.data.dto.common.base.UserDto;
import com.waffle.data.dto.response.user.root.profile.ProfileSlimResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of User with slim information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserSlimResponseDto extends UserDto {

    private ProfileSlimResponseDto profile;
}
