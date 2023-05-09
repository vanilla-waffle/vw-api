package com.waffle.data.models.rest.response.city;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.CityDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * City response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id" })
public class CityResponseDto extends CityDto {

    private Long id;
}
