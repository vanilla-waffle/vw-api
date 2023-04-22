package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vw_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonManagedReference
    private Set<Role> roles;

    /**
     * Listener function that gets executed on insert/persist operation.
     */
    @PrePersist
    public void onPersist() {
        status = UserStatus.INACTIVE;
    }
}
