package com.waffle.configurations.security.jwt;

/**
 * Jwt tools accessor.
 */
public final class Jwt {

    private Jwt() {
    }

    /**
     * Jwt provider.
     *
     * @return {@link JwtProvider}
     */
    public static JwtProvider provider() {
        return new JwtProvider();
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
