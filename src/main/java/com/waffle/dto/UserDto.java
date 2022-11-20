package com.waffle.dto;

import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;

/**
 * DTO class for User entity.
 */
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:VisibilityModifier"})
public enum UserDto {;

    private interface Id {
        @Positive Long getId();
    }

    private interface Posts {
        Collection<PostDto.Response.Slim> getPosts();
    }

    private interface Profile {
        @NotNull com.waffle.entity.Profile getProfile();
    }

    /**
     * Request objects of UserDto.
     */
    public enum Request {;

        /**
         * Request for create User.
         */
        @Data
        public static class Create implements UserDto.Profile {
            com.waffle.entity.Profile profile;
        }
    }

    /**
     * Response objects of UserDto.
     */
    public enum Response {;

        /**
         * Response object with all information.
         */
        @Value
        public static class All implements Id, Posts {
            Long id;
            Collection<PostDto.Response.Slim> posts;
        }
    }
}
