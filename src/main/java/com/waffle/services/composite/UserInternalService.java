package com.waffle.services.composite;

import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;

import java.util.List;

/**
 * User internal service.
 */
public interface UserInternalService {

    /**
     * Find all.
     *
     * @param sort {@link String}
     * @return {@link List<UserSlimResponseDto>}
     */
    List<UserSlimResponseDto> findAll(String sort);

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
     * Delete user.
     *
     * @param id {@link Long}
     */
    void delete(Long id);
}
