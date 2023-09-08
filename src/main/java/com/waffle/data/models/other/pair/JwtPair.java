package com.waffle.data.models.other.pair;

import lombok.Builder;
import lombok.Data;

/**
 * Jwt pair of access and refresh tokens.
 */
@Data
@Builder
public class JwtPair {

    private String access;
    private String refresh;
}
