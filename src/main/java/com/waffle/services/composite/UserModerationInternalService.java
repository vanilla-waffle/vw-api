package com.waffle.services.composite;

import com.waffle.data.models.rest.request.license.DriverLicenseCreateDto;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * User moderation internal service.
 */
public interface UserModerationInternalService {

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page {@link PageRequest}
     * @return {@link Page<UserModerationAllResponseDto>}
     */
    Page<UserModerationAllResponseDto> findAll(String query, PageRequest page);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page {@link PageRequest}
     * @param userId {@link Long}
     * @return {@link Page<UserModerationAllResponseDto>}
     */
    Page<UserModerationAllResponseDto> findAll(String query, PageRequest page, Long userId);

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto find(Long id);

    /**
     * Save one.
     *
     * @param payload {@link DriverLicenseCreateDto}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto save(DriverLicenseCreateDto payload);

    /**
     * Approve.
     *
     * @param id {@link Long}
     * @param adminId {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto approve(Long id, Long adminId);

    /**
     * Reject.
     *
     * @param id      {@link Long}
     * @param adminId {@link Long}
     * @param message {@link String}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto reject(Long id, Long adminId, String message);

    /**
     * Delete.
     *
     * @param id {@link Long}
     * @param adminId {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto delete(Long id, Long adminId);

    /**
     * Erase.
     *
     * @param id {@link Long}
     */
    void erase(Long id);
}
