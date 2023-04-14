package com.waffle.data.models.other;

import lombok.Data;

/**
 * Pair of username and password.
 */
@Data
public class CredentialsPair {

    private String username;
    private String password;
}
