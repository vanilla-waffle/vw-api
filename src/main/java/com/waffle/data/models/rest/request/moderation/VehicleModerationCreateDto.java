package com.waffle.data.models.rest.request.moderation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Vehicle moderation dto.
 */
@Data
public class VehicleModerationCreateDto {

    @JsonIgnore
    private Long userId;
    @NotNull
    @Positive
    private Long passportId;
}
