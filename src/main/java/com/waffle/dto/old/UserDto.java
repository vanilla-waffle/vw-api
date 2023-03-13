package com.waffle.dto.old;

import com.waffle.models.constants.types.Status;
import lombok.Data;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * DTO class for User entity.
 */
public enum UserDto {
    ;

    /**
     * Request objects of UserDto.
     */
    public enum Request {
        ;

        /**
         * Request for create User.
         */
        @Data
        public static class Create {
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
        public static class All {
            private Long id;
            private Collection<PostDto.Response.Slim> posts;
        }

        /**
         * Response object with short information of User.
         */
        @Data
        public static class Slim {
            private Long id;
            private LocalDateTime createdAt;
            private Status status;
            private ProfileDto.Response.Slim profile;
        }
    }
}
