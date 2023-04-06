package com.waffle.configurations.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.waffle.data.dto.other.UserContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Map;

/**
 * JWT manager-provider.
 */
public class JwtProvider {

    private static final String SECRET = "0ilQ17mQF&7m";
    private static final String ISSUER = "wafflix";
    private static final long EXPIRES_AFTER = 1_800_000;

    /**
     * Get principal form token.
     *
     * @param token {@link String}
     * @return {@link Authentication}
     */
    public Authentication authentication(final String token) {
        Map<String, Claim> claims = claims(token);
        return new UsernamePasswordAuthenticationToken(claims.get("sub").asString(), claims.get("user_id").asString(), claims.get("roles").asList(GrantedAuthority.class));
    }

    /**
     * Generate token from provided user info.
     *
     * @param u {@link UserDetails}
     * @return {@link String} token
     */
    public String token(final UserContext u) {
        return JWT.create()
                .withClaim("user_id", u.getId().toString())
                .withClaim("user_status", u.getStatus().toString())
                .withClaim("roles", u.getAuthorities().toString())
                .withSubject(u.getUsername())
                .withIssuer(ISSUER)
                .withExpiresAt(getExpiresAt())
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * Generate refresh token with 2x extended expiration time.
     *
     * @param u {@link UserDetails}
     * @return {@link String} refresh token
     */
    public String refreshToken(final UserContext u) {
        return JWT.create()
                .withSubject(u.getUsername())
                .withExpiresAt(getExpiresAt(2))
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

    private Instant getExpiresAt() {
        return Instant.now().plusMillis(EXPIRES_AFTER);
    }

    private Instant getExpiresAt(final int x) {
        return Instant.now().plusMillis(EXPIRES_AFTER * x);
    }
}
