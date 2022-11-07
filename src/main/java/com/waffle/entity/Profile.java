package com.waffle.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {

    private String login;
    private String email;
    private String password;
    private String name;
}
