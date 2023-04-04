package com.waffle.data.dto.request.user;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.dto.common.base.ProfileDto;
import lombok.Data;

/**
 * Request, dto class to update a User.
 */
@Data
public class UserUpdateDto {

    private Long id;
    private UserStatus status;

    private ProfileDto profile;
}
