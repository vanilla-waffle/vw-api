package com.waffle.data.dto.response.user;

import com.waffle.data.dto.common.base.UserDto;
import com.waffle.data.dto.response.user.profile.ProfileAllDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Response, dto class of User with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAllDto extends UserDto {

    private ProfileAllDto profile;
}

