package com.waffle.services.composite.impl;

import com.waffle.data.entities.DriverLicense;
import com.waffle.data.entities.User;
import com.waffle.data.entities.admin.UserModeration;
import com.waffle.data.models.rest.request.license.DriverLicenseCreateDto;
import com.waffle.data.utils.mappers.DriverLicenseMapper;
import com.waffle.data.utils.mappers.UserModerationMapper;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import com.waffle.services.utils.Sorts;
import com.waffle.services.composite.UserModerationInternalService;
import com.waffle.services.entity.DriverLicenseService;
import com.waffle.services.entity.UserModerationService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.waffle.data.repositories.specifications.UserModerationSpecification.byUser;
import static com.waffle.data.constants.types.admin.ModerationStatus.*;
import static com.waffle.data.constants.types.user.UserStatus.ACTIVE;

/**
 * User moderation internal service implementation.
 */
@Service
@RequiredArgsConstructor
public class UserModerationInternalServiceImpl implements UserModerationInternalService {
    private final UserModerationService userModerationService;
    private final DriverLicenseService driverLicenseService;
    private final UserService userService;
    private final UserModerationMapper userModerationMapper;
    private final DriverLicenseMapper driverLicenseMapper;

    @Override
    public Page<UserModerationAllResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<UserModeration> moderations = userModerationService.findAll(sort, page);
        return moderations.map(userModerationMapper::convertAll);
    }

    @Override
    public Page<UserModerationAllResponseDto> findAll(final String query, final PageRequest page, final Long userId) {
        final Sort sort = Sorts.of(query);
        final Page<UserModeration> moderations = userModerationService.findAll(sort, page, byUser(userId));
        return moderations.map(userModerationMapper::convertAll);
    }

    @Override
    public UserModerationAllResponseDto find(final Long id) {
        final UserModeration moderation = userModerationService.find(id);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    @Transactional
    public UserModerationAllResponseDto save(final DriverLicenseCreateDto payload) {
        final User user = userService.find(payload.getUserId());

        if (user.getStatus().equals(ACTIVE) && user.getProfile().getDriverLicense() != null) {
            throw new IllegalArgumentException("User is already active");
        }

        DriverLicense license = driverLicenseMapper.convert(payload);
        license = driverLicenseService.save(license);
        UserModeration moderation = UserModeration.of(user, license);
        moderation = userModerationService.save(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    @Transactional
    public UserModerationAllResponseDto approve(final Long id, final Long adminId) {
        UserModeration moderation = userModerationService.find(id);

        if (!moderation.getStatus().equals(ON_REVIEW)) {
            throw new IllegalArgumentException("Moderation request was already processed: " + id);
        }

        final User admin = userService.find(adminId);
        final User user = moderation.getUser();
        final DriverLicense license = moderation.getLicense();

        moderation.setStatus(APPROVED);
        moderation.setAdmin(admin);
        license.setApproved(true);
        user.getProfile().setDriverLicense(license);
        user.setStatus(ACTIVE);

        userService.update(user);
        moderation = userModerationService.update(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    public UserModerationAllResponseDto reject(final Long id, final Long adminId, final String message) {
        UserModeration moderation = userModerationService.find(id);

        if (!moderation.getStatus().equals(ON_REVIEW)) {
            throw new IllegalArgumentException("Moderation request was already processed: " + id);
        }

        final User admin = userService.find(adminId);

        moderation.setStatus(REJECTED);
        moderation.setAdmin(admin);
        moderation.setMessage(message);

        moderation = userModerationService.merge(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    public UserModerationAllResponseDto delete(final Long id, final Long adminId) {
        final User admin = userService.find(adminId);

        UserModeration moderation = userModerationService.find(id);

        moderation.setStatus(DELETED);
        moderation.setAdmin(admin);

        moderation = userModerationService.merge(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    public void erase(final Long id) {
        userModerationService.delete(id);
    }
}
