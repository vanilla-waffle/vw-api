package com.waffle.data.entities.embedded.vehicle;

import com.waffle.data.constants.types.vehicle.*;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Embedded Specification class for Post entity.
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specification {

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Body body;

    @Enumerated(EnumType.STRING)
    private Drive drive;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    private Double engineVolume;
    private Integer doors;
    private Integer seats;
}
