package com.waffle.services.entity;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.entities.Role;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.PagingService;

/**
 * Role service.
 */
public interface RoleService extends
        BasicService<Role>,
        PagingService<Role> {

    /**
     * Exists by name.
     *
     * @param name {@link String}
     * @return {@code boolean}
     */
    boolean exists(String name);

    /**
     * Find one.
     *
     * @param role {@link RoleType}
     * @return {@link Role}
     */
    Role find(RoleType role);
}
