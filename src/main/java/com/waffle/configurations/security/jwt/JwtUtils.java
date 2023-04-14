package com.waffle.configurations.security.jwt;

import javax.servlet.http.HttpServletRequest;

/**
 * JWT utils.
 */
public class JwtUtils {

    /**
     * Get token from request header.
     *
     * @param request {@link HttpServletRequest}
     * @return {@link String} token. {@link null} if header is invalid
     */
    public String getTokenFromRequestHeader(final HttpServletRequest request) {
        final String prefix = request.getHeader("Authorization");
        if (prefix != null && !prefix.isBlank() && prefix.startsWith("Bearer ")) {
            return prefix.split(" ")[1];
        } else {
            return null;
        }
    }
}
