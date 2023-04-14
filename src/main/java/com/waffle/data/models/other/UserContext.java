package com.waffle.data.models.other;

import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Extended {@link User} class with extra fields.
 */
@Getter
@Accessors(fluent = true)
public class UserContext extends User {
    private final UserAllResponseDto data;

    /**
     * Constructor.
     *
     * @param username {@link String}
     * @param password {@link String}
     * @param data {@link UserAllResponseDto}
     * @param authorities {@link Collection<GrantedAuthority>}
     */
    public UserContext(
            final String username,
            final String password,
            final UserAllResponseDto data,
            final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.data = data;
    }
}
