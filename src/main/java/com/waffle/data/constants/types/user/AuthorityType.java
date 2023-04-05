package com.waffle.data.constants.types.user;

/**
 * Roles.
 */
public enum AuthorityType {

    /**
     * Super administrator with all available privileges and also:
     * + Assign new admins
     * + Remove existing admins.
     */
    ROLE_SUPERADMIN,
    /**
     * Admin with basic administrator privileges.
     */
    ROLE_ADMIN,
    /**
     * Host user.
     */
    ROLE_USER_HOST,
    /**
     * Renter user.
     */
    ROLE_USER_RENTER;
}
