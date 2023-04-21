package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.user.RoleType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User> users;
}
