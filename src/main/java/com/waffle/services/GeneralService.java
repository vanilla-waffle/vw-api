package com.waffle.services;

import com.waffle.data.dto.request.VehicleCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.request.user.UserCreateDto;
import com.waffle.data.dto.request.user.UserUpdateDto;
import com.waffle.data.dto.response.vehicle.VehicleAllDto;
import com.waffle.data.dto.response.user.UserAllDto;
import com.waffle.data.dto.response.user.UserSlimDto;

/**
 * Bridge service between User and Post services.
 */
public interface GeneralService {

    /**
     * Save new post and assign it to existing user.
     *
     * @param payload post
     * @return all response dto
     */
    VehicleAllDto save(VehicleCreateDto payload);

    /**
     * Save new user.
     *
     * @param payload user
     * @return slim response dto
     */
    UserSlimDto save(UserCreateDto payload);

    /**
     * Update existing user.
     *
     * @param payload user
     * @return all response dto
     */
    UserAllDto update(UserUpdateDto payload);

    /**
     * Update existing post.
     *
     * @param payload post
     * @return all response dto
     */
    VehicleAllDto update(PostUpdateDto payload);

    /**
     * Delete existing user.
     *
     * @param userId user id
     */
    void delete(Long userId);

    /**
     * Delete existing post.
     *
     * @param postId post id
     * @param authorId user id
     */
    void delete(Long postId, Long authorId);
}
