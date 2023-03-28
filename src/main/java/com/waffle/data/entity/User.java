package com.waffle.data.entity;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.embedded.user.Profile;
import lombok.*;

import javax.persistence.*;

/**
 * User entity.
 */
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Embedded
    private Profile profile;
}
