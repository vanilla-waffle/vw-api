package com.waffle.data.entities;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.embedded.user.Profile;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * User entity.
 */
@Entity
@Table(name = "vw_users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Embedded
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "vw_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
