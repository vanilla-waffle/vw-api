package com.waffle.data.dto.request.user;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.embedded.user.Profile;
import lombok.Data;

/**
 * Request, dto class to update a User.
 */
@Data
public class UserUpdateDto {

    private UserStatus status;
    private Profile profile;
}
