package com.waffle.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * DTO class for Post entity.
 */
public enum PostDto {
    ;

    private interface Id {
        @Positive Long getId();
    }

    private interface Title {
        @NotBlank String getTitle();
    }

    /**
     * Request objects of PostDto.
     */
    public enum Request {
    }

    /**
     * Response objects of PostDto.
     */
    public enum Response {
        ;

        /**
         * Slim response object of PostDto.
         */
        @Data
        public static class Slim implements Id, Title {
            private Long id;
            private String title;
        }
    }
}
