package com.waffle.data.entity.embedded.vehicle;

import com.waffle.data.constants.types.vehicle.*;
import lombok.*;

import javax.persistence.Column;
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
    @Column(nullable = false)
    private Color color;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Body body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Drive drive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Fuel fuel;

    @Column(nullable = false)
    private Double engineVolume;
    @Column(nullable = false)
    private Integer doors;
    @Column(nullable = false)
    private Integer seats;
}
