package com.waffle.configurations.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.waffle.data.dto.other.UserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.time.Instant;
import java.util.Map;

/**
 * JWT manager-provider.
 */
public class JwtProvider {

    private static final String SECRET = "0ilQ17mQF&7m";
    private static final String ISSUER = "wafflix";
    private static final long EXPIRES_AT = 1_800_000;

    /**
     * Get principal form token.
     *
     * @param token {@link String}
     * @return {@link Authentication}
     */
    public Authentication authentication(final String token) {
        Map<String, Claim> claims = claims(token);
        return new UsernamePasswordAuthenticationToken(claims.get("username").asString(), claims.get("password").asString());
    }

    /**
     * Generate token from provided user info.
     *
     * @param u {@link UserInfo}
     * @return {@link String} token
     */
    public String token(final UserInfo u) {
        return JWT.create()
                .withClaim("user", toClaims(u))
                .withSubject(u.getProfile().getUsername())
                .withIssuer(ISSUER)
                .withExpiresAt(Instant.ofEpochMilli(EXPIRES_AT))
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * Generate refresh token with 2x extended expiration time.
     *
     * @param u {@link UserInfo}
     * @return {@link String} refresh token
     */
    public String refreshToken(final UserInfo u) {
        return JWT.create()
                .withSubject(u.getProfile().getUsername())
                .withExpiresAt(Instant.ofEpochMilli(EXPIRES_AT * 2))
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * Verify token.
     *
     * @param token {@link String}
     * @return {@link Boolean}
     */
    public boolean verify(final String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get claims from token.
     *
     * @param token {@link String} valid token
     * @return {@link Map}
     */
    public Map<String, Claim> claims(final String token) {
        return JWT.decode(token)
                .getClaims();
    }

    /**
     * Convert user information to map of objects.
     *
     * @param u {@link UserInfo}
     * @return {@link Map}
     */
    private Map<String, Object> toClaims(final UserInfo u) {
        return Map.of("profile", u.getProfile());
    }
}
