package com.waffle.data.models.rest.response.user.role;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Role response all dto.
 */
@Data
public class RoleResponseAllDto {

    private Long id;
    private LocalDateTime createdAt;

    private RoleType role;
    private List<UserSlimResponseDto> users;
}
