package com.waffle.data.models.rest.request.moderation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * User moderation create dto.
 */
@Data
public class UserModerationCreateDto {

    @JsonIgnore
    private Long userId;
    @NotNull
    @Positive
    private Long licenseId;
}
