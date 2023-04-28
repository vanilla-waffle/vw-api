package com.waffle.services.composite.impl;

import com.waffle.data.entities.DriverLicense;
import com.waffle.data.entities.User;
import com.waffle.data.entities.admin.UserModeration;
import com.waffle.data.mappers.UserModerationMapper;
import com.waffle.data.models.rest.request.moderation.UserModerationCreateDto;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import com.waffle.data.utils.Sorts;
import com.waffle.services.composite.UserModerationInternalService;
import com.waffle.services.entity.DriverLicenseService;
import com.waffle.services.entity.UserModerationService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.waffle.repositories.specifications.UserModerationSpecification.byUser;
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
    public UserModerationAllResponseDto save(final UserModerationCreateDto payload) {
        final User user = userService.find(payload.getUserId());
        final DriverLicense license = user.getProfile().getDriverLicense();

        UserModeration moderation = userModerationMapper.convert(payload);
        moderation.setUser(user);
        moderation.setLicense(license);

        moderation = userModerationService.save(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    @Transactional
    public UserModerationAllResponseDto approve(final Long id, final Long adminId) {
        final User admin = userService.find(adminId);

        UserModeration moderation = userModerationService.find(id);
        final DriverLicense license = moderation.getLicense();
        final User user = moderation.getUser();

        moderation.setStatus(APPROVED);
        moderation.setAdmin(admin);
        license.setApproved(true);
        user.setStatus(ACTIVE);

        driverLicenseService.update(license);
        userService.update(user);
        moderation = userModerationService.update(moderation);
        return userModerationMapper.convertAll(moderation);
    }

    @Override
    public UserModerationAllResponseDto reject(final Long id, final Long adminId, final String message) {
        final User admin = userService.find(adminId);

        UserModeration moderation = userModerationService.find(id);

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
