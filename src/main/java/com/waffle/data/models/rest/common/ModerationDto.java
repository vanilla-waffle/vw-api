package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.admin.ModerationStatus;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import lombok.Data;

/**
 * Moderation dto.
 */
@Data
public class ModerationDto {

    private ModerationStatus status;
    private String message;

    private UserSlimResponseDto admin;
    private UserSlimResponseDto user;
}
