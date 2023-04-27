package com.waffle.data.entities;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.embedded.user.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * User entity.
 */
@Entity
@Table(name = "vw_users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BasicEntity {

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Embedded
    private Profile profile;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    /**
     * Listener function that gets executed on insert/persist operation.
     */
    @PrePersist
    public void onPersist() {
        status = UserStatus.INACTIVE;
    }
}
