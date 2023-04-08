package com.waffle.data.models.rest.response.user.root;

import com.waffle.data.models.rest.common.root.UserDto;
import com.waffle.data.models.rest.response.user.root.profile.ProfileAllResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of User with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAllResponseDto extends UserDto {

    private ProfileAllResponseDto profile;
}

