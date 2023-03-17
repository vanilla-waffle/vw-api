package com.waffle.data.dto.request;

import com.waffle.data.constants.types.Status;
import com.waffle.data.embedded.Profile;
import lombok.Data;

/**
 * Request, dto class to update a User.
 */
@Data
public class UserUpdateDto {
    private Status status;
    private Profile profile;
}
