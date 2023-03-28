package com.waffle.data.dto.common;

import com.waffle.data.dto.response.ProfileSlimDto;
import com.waffle.data.constants.types.user.UserStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
@Data
public class UserDto {
    private LocalDateTime createdAt;
    private UserStatus status;

    @NotNull
    private ProfileSlimDto profile;
}
