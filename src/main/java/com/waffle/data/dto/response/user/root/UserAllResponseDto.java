package com.waffle.data.dto.response.user.root;

import com.waffle.data.dto.common.base.UserDto;
import com.waffle.data.dto.response.user.root.profile.ProfileAllResponseDto;
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

