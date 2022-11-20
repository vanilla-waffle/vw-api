package com.waffle.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * DTO class for Post entity.
 */
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:VisibilityModifier"})
public enum PostDto {;
    private interface Id {
        @Positive Long getId();
    }

    private interface Title {
        @NotBlank String getTitle();
    }

    /**
     * Request objects of PostDto.
     */
    public enum Request {}

    /**
     * Response objects of PostDto.
     */
    public enum Response {;
        /**
         * Slim response object of PostDto.
         */
        @Value
        public static class Slim implements Id, Title {
            Long id;
            String title;
        }
    }
}
