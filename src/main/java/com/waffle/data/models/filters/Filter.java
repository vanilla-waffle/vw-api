package com.waffle.data.models.filters;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Base filter.
 */
@Getter
public class Filter {

    private LocalDateTime createdAt;
}
