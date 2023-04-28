package com.waffle.data.entities;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Authority entity for role managements.
 */
@Entity
@Table(name = "vw_roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends BasicEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @ManyToMany
    @JoinTable(
            name = "vw_users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
