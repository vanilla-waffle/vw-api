package com.waffle.services.composite;

import com.waffle.data.dto.other.UserContext;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User context service.
 */
public interface UserContextService extends UserDetailsService {

    /**
     * Find user by username.
     *
     * @param username {@link String} username
     * @return {@link UserContext}
     * @throws UsernameNotFoundException invalid username
     */
    UserContext load(String username) throws UsernameNotFoundException;
}
