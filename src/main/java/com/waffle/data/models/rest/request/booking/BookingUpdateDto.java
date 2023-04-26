package com.waffle.data.models.rest.request.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.common.BookingDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * Booking update dto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BookingUpdateDto extends BookingDto {

    private Long id;

    @JsonIgnore
    private Long userId;
}
