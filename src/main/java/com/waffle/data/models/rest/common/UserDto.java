package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.user.UserStatus;
import lombok.Data;

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
