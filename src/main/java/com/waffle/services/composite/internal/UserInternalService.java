package com.waffle.services.composite.internal;

import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * User internal service.
 */
public interface UserInternalService {

    /**
     * Find all.
     *
     * @param query {@link String}
     * @return {@link List<UserSlimResponseDto>}
     */
    List<UserSlimResponseDto> findAll(String query);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page  {@link PageRequest}
     * @return {@link Page<UserAllResponseDto>}
     */
    Page<UserSlimResponseDto> findAll(String query, PageRequest page);

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto find(Long id);

    /**
     * Update user.
     *
     * @param payload {@link UserUpdateDto}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto update(UserUpdateDto payload);

    /**
     * Activate user.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto activate(Long id);

    /**
     * Mark user as deleted.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto delete(Long id);

    /**
     * Erase user record from db.
     *
     * @param id {@link Long}
     */
    void erase(Long id);
}
