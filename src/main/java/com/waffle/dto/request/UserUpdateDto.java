package com.waffle.dto.request;

import com.waffle.models.constants.types.Status;
import com.waffle.models.embedded.Profile;
import lombok.Data;

/**
 * Request, dto class to update a User.
 */
@Data
public class UserUpdateDto {
    private Status status;
    private Profile profile;
}
