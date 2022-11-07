package com.waffle.entity;

import javax.persistence.Embeddable;

/**
 * Embedded Profile entity.
 */
@Embeddable
public class Profile {

    private String login;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
