package com.waffle.data.models.rest.request.user.role;

import com.waffle.data.constants.types.user.RoleType;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Role create dto.
 */
@Data
public class RoleCreateDto {

    @NotNull
    private RoleType type;
}
