package com.waffle.dto;

import com.waffle.model.constants.embedded.Profile;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;

/**
 * DTO class for User entity.
 */
public enum UserDto {
    ;

    private interface Id {
        @Positive Long getId();
    }

    private interface ProfileDTO {
        @NotNull Profile getProfile();
    }

    private interface Posts {
        Collection<PostDto.Response.Slim> getPosts();
    }

    /**
     * Request objects of UserDto.
     */
    public enum Request {
        ;

        /**
         * Request for create User.
         */
        @Data
        public static class Create implements ProfileDTO {
            private Profile profile;
        }
    }

    /**
     * Response objects of UserDto.
     */
    public enum Response {
        ;

        /**
         * Response object with all information.
         */
        @Data
        public static class All implements Id, Posts {
            private Long id;
            private Collection<PostDto.Response.Slim> posts;
        }
    }
}
