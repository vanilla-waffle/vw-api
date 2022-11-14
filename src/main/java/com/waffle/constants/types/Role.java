package com.waffle.constants.types;

/**
 * Roles.
 */
public enum Role {

    /**
     * Super administrator with all available privileges and also:
     *
     * + Assign new admins
     * + Remove existing admins.
     */
    SUPERADMIN,
    /**
     * Admin with basic administrator privileges.
     */
    ADMIN
}
