package com.waffle.models.embedded;

import com.waffle.models.constants.types.*;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Embedded Specification class for Post entity.
 */
@Embeddable
@Getter
@Setter
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

    private Integer engineVolume;
    private Integer doors;
    private Integer seats;
}
