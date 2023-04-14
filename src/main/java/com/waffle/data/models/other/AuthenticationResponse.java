package com.waffle.data.models.other;

import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import lombok.Builder;
import lombok.Data;

/**
 * Authentication response dto.
 */
@Data
@Builder
public class AuthenticationResponse {

    private JwtPair auth;
    private UserAllResponseDto user;
}
