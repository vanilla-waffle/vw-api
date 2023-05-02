package com.waffle.data.models.rest.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.common.ProfileDto;
import lombok.Data;

/**
 * Request, dto class to update a User.
 */
@Data
public class UserUpdateDto {

    @JsonIgnore
    private Long id;

    private ProfileDto profile;
}
