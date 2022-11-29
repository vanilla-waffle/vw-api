package com.waffle.model.constants.embedded;

import com.waffle.model.constants.types.*;
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
    private Integer engineVolume;
    @Enumerated(EnumType.STRING)
    private Drive drive;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Integer doors;
    private Integer seats;
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
}
