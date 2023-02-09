package com.waffle.dto;

import com.waffle.models.constants.types.City;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO class of embedded class Profile for User.
 */
public enum ProfileDto {
    ;

    private interface Email {
        @NotBlank @NotNull String getEmail();
    }

    private interface Password {
        @NotBlank @NotNull String getPassword();
    }

    private interface FirstName {
        @NotBlank @NotNull String getFirstName();
    }

    private interface LastName {
        @NotBlank @NotNull String getLastName();
    }

    private interface CityEnum {
        @NotNull City getCity();
    }

    /**
     * Request objects of ProfileDto.
     */
    public enum Request {
        ;

        /**
         * Request for create User.
         */
        @Data
        public static class Create implements Email, Password, FirstName, LastName, CityEnum {
            private String email;
            private String password;
            private String firstName;
            private String lastName;
            private City city;
        }
    }

    /**
     * Response objects of ProfileDto.
     */
    public enum Response {
        ;

        /**
         * Response with profile information of User.
         */
        @Data
        public static class Slim implements Email, FirstName, LastName, CityEnum {
            private String email;
            private String firstName;
            private String lastName;
            private City city;
        }
    }
}
