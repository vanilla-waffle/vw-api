package com.waffle.data.constants.types.user;

/**
 * Account statuses.
 */
public enum UserStatus {

    /**
     * Waiting for moderation.
     */
    PENDING,
    /**
     * Account status after activation.
     */
    ACTIVE,
    /**
     * Default account status.
     */
    INACTIVE,
    /**
     * Status of banned accounts.
     */
    BANNED
}
