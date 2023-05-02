package com.waffle.configurations.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.waffle.configurations.properties.JwtSettings;
import com.waffle.data.models.other.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Jwt provider.
 */
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtSettings settings;

    /**
     * Get principal from token.
     *
     * @param token {@link String}
     * @return {@link Authentication}
     */
    public Authentication auth(final String token) {
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        return new UsernamePasswordAuthenticationToken(
                claims.get("id").asLong(),
                null,
                claims.get("roles").asList(String.class).stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }

    /**
     * Get claim from token.
     *
     * @param token {@link String}
     * @param name {@link String} claim
     * @return {@link String} value
     */
    public String claim(final String token, final String name) {
        return JWT.decode(token).getClaims().get(name).asString();
    }

    /**
     * Basic token generator.
     *
     * @param ctx {@link UserContext}
     * @return {@link String} token
     */
    public String generate(final UserContext ctx) {
        final List<String> authorities = ctx.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return JWT.create()
                .withSubject(ctx.getUsername())
                .withClaim("id", ctx.data().getId())
                .withClaim("roles", authorities)
                .withIssuer(settings.issuer())
                .withExpiresAt(Instant.now().plusSeconds(settings.accessExpiresAt()))
                .sign(Algorithm.HMAC256(settings.secret()));
    }

    /**
     * Refresh token generator.
     *
     * @param ctx {@link UserContext}
     * @return {@link String}
     */
    public String generateRefresh(final UserContext ctx) {
        final List<String> authorities = ctx.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return JWT.create()
                .withSubject(ctx.getUsername())
                .withClaim("roles", authorities)
                .withIssuer(settings.issuer())
                .withExpiresAt(Instant.now().plusSeconds(settings.refreshExpiresAt()))
                .sign(Algorithm.HMAC256(settings.secret()));
    }

    /**
     * Checks wether token is valid or not.
     *
     * @param token {@link String}
     * @return {@link Boolean}
     */
    public boolean valid(final String token) {
        try {
            JWTVerifier verifier = JWT
                    .require(Algorithm.HMAC256(settings.secret()))
                    .withIssuer(settings.issuer())
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
