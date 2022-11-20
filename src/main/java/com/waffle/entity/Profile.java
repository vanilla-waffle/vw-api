package com.waffle.entity;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * Embedded Profile entity.
 */
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
