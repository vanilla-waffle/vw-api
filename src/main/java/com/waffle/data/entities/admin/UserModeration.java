package com.waffle.data.entities.admin;

import com.waffle.data.entities.DriverLicense;
import com.waffle.data.entities.User;
import com.waffle.data.entities.root.ModerationEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vw_users_moderation_requests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class UserModeration extends ModerationEntity {

    @OneToOne
    @JoinColumn(name = "license_id", nullable = false)
    private DriverLicense license;

    private UserModeration(final User user, final DriverLicense license) {
        this.license = license;
        this.setUser(user);
    }

    /**
     * Static constructor.
     *
     * @param user {@link User}
     * @param license {@link DriverLicense}
     * @return {@link UserModeration}
     */
    public static UserModeration of(final User user, final DriverLicense license) {
        return new UserModeration(user, license);
    }
}
