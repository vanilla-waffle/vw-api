package com.waffle.data.entities;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.behaviour.Persistable;
import com.waffle.data.entities.embedded.user.Profile;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * User entity.
 */
@Entity
@Table(name = "vw_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BasicEntity implements Persistable {

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Embedded
    private Profile profile;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @Override
    @PrePersist
    public void onPersist() {
        status = UserStatus.INACTIVE;
    }
}
