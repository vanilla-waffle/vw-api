package com.waffle.services.composite;

import com.waffle.data.constants.types.user.Role;
import org.springframework.stereotype.Service;

/**
 * Admin service for platform moderation.
 */
@Service
public interface AdminService {

    /**
     * Freeze user.
     *
     * @param userId user id
     * @param duration ban duration
     */
    void ban(Long userId, Long duration);

    /**
     * Assign a role {@link Role} for user.
     *
     * @param userId user id
     * @param role role
     */
    void grant(Long userId, Role role);
}
