package com.waffle.dto;

import com.waffle.models.constants.types.Status;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * DTO class for User entity.
 */
public enum UserDto {
    ;

    private interface Id {
        @Positive Long getId();
    }

    private interface CreatedAt {
        LocalDateTime getCreatedAt();
    }

    private interface StatusEnum {
        @NotBlank @NotNull Status getStatus();
    }

    private interface ProfileEmbeddedCreate {
        @NotNull ProfileDto.Request.Create getProfile();
    }

    private interface ProfileEmbeddedSlim {
        @NotNull ProfileDto.Response.Slim getProfile();
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
        public static class Create implements ProfileEmbeddedCreate {
            @Valid
            private ProfileDto.Request.Create profile;
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

        /**
         * Response object with short information of User.
         */
        @Data
        public static class Slim implements Id, CreatedAt, StatusEnum, ProfileEmbeddedSlim {
            private Long id;
            private LocalDateTime createdAt;
            private Status status;
            private ProfileDto.Response.Slim profile;
        }
    }
}
