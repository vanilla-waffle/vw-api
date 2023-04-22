package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.user.RoleType;
import lombok.Data;

/**
 * Role dto.
 */
@Data
public class RoleDto {

    private RoleType role;
}
