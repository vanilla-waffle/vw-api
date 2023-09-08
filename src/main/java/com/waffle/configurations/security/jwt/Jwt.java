package com.waffle.configurations.security.jwt;

import com.waffle.configurations.properties.JwtSettings;
import com.waffle.data.models.other.pair.JwtPair;
import com.waffle.data.models.other.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Jwt manager class.
 */
@Component
@RequiredArgsConstructor
public class Jwt {
    private final JwtSettings settings;

    /**
     * Generate a pair of jwt tokens.
     *
     * @param ctx {@link UserContext}
     * @return {@link JwtPair}
     */
    public JwtPair pair(final UserContext ctx) {
        return JwtPair.builder()
                .access(provider().generate(ctx))
                .refresh(provider().generateRefresh(ctx))
                .build();
    }

    /**
     * Jwt provider.
     *
     * @return {@link JwtProvider}
     */
    public JwtProvider provider() {
        return new JwtProvider(settings);
    }

    /**
     * Jwt utils.
     *
     * @return {@link JwtUtils}
     */
    public static JwtUtils utils() {
        return new JwtUtils();
    }
}
