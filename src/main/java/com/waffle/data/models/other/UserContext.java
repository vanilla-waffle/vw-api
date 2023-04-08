package com.waffle.data.models.other;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Extended {@link User} class with extra fields.
 */
@Getter
public class UserContext extends User {
    private final Long id;

    /**
     * Constructor.
     *
     * @param id {@link Long}
     * @param username {@link String}
     * @param password {@link String}
     * @param authorities {@link Collection<GrantedAuthority>}
     */
    public UserContext(
            final Long id,
            final String username,
            final String password,
            final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }
}
