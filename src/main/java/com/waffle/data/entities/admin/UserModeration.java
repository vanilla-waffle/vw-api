package com.waffle.data.entities.admin;

import com.waffle.data.entities.DriverLicense;
import com.waffle.data.entities.root.ModerationEntity;
import lombok.*;

import javax.persistence.*;

/**
 * User moderation request entity.
 */
@Entity
@Table(name = "vw_users_moderation_requests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserModeration extends ModerationEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id", nullable = false)
    private DriverLicense license;
}
