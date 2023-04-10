package com.waffle.data.models.rest.response.user.root;

import com.waffle.data.models.rest.common.root.UserDto;
import com.waffle.data.models.rest.response.user.root.profile.ProfilePublicResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User public response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPublicResponseDto extends UserDto {

    private ProfilePublicResponseDto profile;
}

