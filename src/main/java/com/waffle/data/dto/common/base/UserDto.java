package com.waffle.data.dto.common.base;

import com.waffle.data.dto.response.user.profile.ProfileSlimDto;
import com.waffle.data.constants.types.user.UserStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
@Data
public class UserDto {

    private Long id;
    private LocalDateTime createdAt;
    private UserStatus status;
}
