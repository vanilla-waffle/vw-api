package com.waffle.services.composite;

import com.waffle.data.constants.types.user.AuthorityType;
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
     * Assign a role {@link AuthorityType} for user.
     *
     * @param userId user id
     * @param role role
     */
    void grant(Long userId, AuthorityType role);
}
