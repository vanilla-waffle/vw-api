package com.waffle.data.models.rest.request.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.common.BookingDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Booking update dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookingUpdateDto extends BookingDto {

    @NotNull
    @Positive
    private Long id;

    @JsonIgnore
    private Long userId;
}
