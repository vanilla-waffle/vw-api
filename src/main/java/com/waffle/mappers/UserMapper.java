package com.waffle.mappers;

import com.waffle.dto.ProfileDto;
import com.waffle.dto.UserDto;
import com.waffle.models.embedded.Profile;
import com.waffle.models.entity.User;
import org.springframework.stereotype.Component;

import static com.waffle.models.constants.types.Status.ACTIVE;

/**
 * User-DTO mapper
 */
@Component
public class UserMapper {

    /**
     * Map from {@link com.waffle.dto.UserDto.Request.Create} to {@link User}
     *
     * @param source user create dto
     * @return user entity
     */
    public User createdToUser(final UserDto.Request.Create source) {
        if (source == null) {
            return new User();
        }

        ProfileDto.Request.Create profile = source.getProfile();

        return User.builder()
                .profile(
                        Profile.builder()
                                .city(profile.getCity())
                                .email(profile.getEmail())
                                .firstName(profile.getFirstName())
                                .lastName(profile.getLastName())
                                .password(profile.getPassword())
                                .build()
                )
                .status(ACTIVE)
                .build();
    }

        /**
         * Work-in-progress
         *
         * @param source .
         * @return .
         */
    public UserDto.Request.Create userToCreated(final User source) {
        return null;

    }
    public User toUpdatedUser(final UserDto.Request.Create source, final User user) {
        if (source == null) {
            return new User();
        }

        ProfileDto.Request.Create sourceProfile = source.getProfile();
        Profile userProfile = user.getProfile();

        return User.builder()
                .profile(
                        Profile.builder()
                                .city(sourceProfile.getCity() == null ? userProfile.getCity() : sourceProfile.getCity())
                                .email(sourceProfile.getEmail() == null ? userProfile.getEmail() : sourceProfile.getEmail())
                                .firstName(sourceProfile.getFirstName() == null ? userProfile.getFirstName() : sourceProfile.getFirstName())
                                .lastName(sourceProfile.getLastName() == null ? userProfile.getLastName() : sourceProfile.getLastName())
                                .password(sourceProfile.getPassword() == null ? userProfile.getPassword() : sourceProfile.getPassword())
                                .build()
                )
                .build();
    }
}
