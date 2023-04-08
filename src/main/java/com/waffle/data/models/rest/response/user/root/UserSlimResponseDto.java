package com.waffle.data.models.rest.response.user.root;

import com.waffle.data.models.rest.common.root.UserDto;
import com.waffle.data.models.rest.response.user.root.profile.ProfileSlimResponseDto;
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
