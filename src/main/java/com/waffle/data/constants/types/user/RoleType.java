package com.waffle.data.constants.types.user;

/**
 * Roles.
 */
public enum RoleType {

    /**
     * Super administrator with all available privileges and also:
     * + Assign new admins
     * + Remove existing admins.
     */
    SUPERADMIN,
    /**
     * Admin with basic administrator privileges.
     */
    ADMIN,
    /**
     * Basic user that provides vehicle for renters.
     */
    USER_HOST,
    /**
     * Basic user that rents a vehicle.
     */
    USER_RENTER;
}
