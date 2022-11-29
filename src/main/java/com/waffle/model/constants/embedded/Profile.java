package com.waffle.model.constants.embedded;

import com.waffle.model.constants.types.City;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Embedded Profile class for User entity.
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private String email;
    @Enumerated(EnumType.STRING)
    private City city;
    private String password;
    private String firstName;
    private String lastName;
}
