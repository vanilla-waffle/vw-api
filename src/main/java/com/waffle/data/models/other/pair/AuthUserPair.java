package com.waffle.data.models.other.pair;

import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import lombok.Builder;
import lombok.Data;

/**
 * Authentication response dto.
 */
@Data
@Builder
public class AuthUserPair {

    private JwtPair auth;
    private UserAllResponseDto user;
}
