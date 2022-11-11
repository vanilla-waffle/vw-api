package com.waffle.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

/**
 * User entity.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Post> posts;
}
