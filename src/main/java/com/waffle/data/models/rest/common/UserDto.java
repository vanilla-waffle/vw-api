package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.models.rest.response.media.ImageResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
@Data
public class UserDto {

    private UserStatus status;

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ImageResponseDto image;
}
