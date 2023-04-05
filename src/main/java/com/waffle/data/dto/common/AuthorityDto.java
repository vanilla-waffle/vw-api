package com.waffle.data.dto.common;

import com.waffle.data.constants.types.user.AuthorityType;
import lombok.Data;

/**
 * Role dto
 */
@Data
public class AuthorityDto {

    private AuthorityType name;
}
