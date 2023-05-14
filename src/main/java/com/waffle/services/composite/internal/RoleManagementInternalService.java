package com.waffle.services.composite.internal;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.models.rest.request.user.role.RoleCreateDto;
import com.waffle.data.models.rest.response.user.role.RoleResponseAllDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Role management service.
 */
public interface RoleManagementInternalService {

    /**
     * Assign role.
     *
     * @param id {@link Long}
     * @param type {@link RoleType}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto promote(Long id, RoleType type);

    /**
     * Take away role.
     *
     * @param id {@link Long}
     * @param type {@link RoleType}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto demote(Long id, RoleType type);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page {@link PageRequest}
     * @return {@link Page<RoleResponseAllDto>}
     */
    Page<RoleResponseAllDto> findAll(String query, PageRequest page);

    /**
     * Find by id.
     *
     * @param id {@link Long}
     * @return {@link RoleResponseAllDto}
     */
    RoleResponseAllDto find(Long id);

    /**
     * Find by name.
     *
     * @param type {@link RoleType}
     * @return {@link RoleResponseAllDto}
     */
    RoleResponseAllDto find(RoleType type);

    /**
     * Save one.
     *
     * @param payload {@link RoleCreateDto}
     * @return {@link RoleResponseAllDto}
     */
    RoleResponseAllDto save(RoleCreateDto payload);

    /**
     * Delete one.
     *
     * @param id {@link Long}
     */
    void delete(Long id);
}
