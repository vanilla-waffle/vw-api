package com.waffle.data.entities;

import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Vehicle location entity.
 */
@Entity
@Table(name = "vw_locations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Location extends BasicEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;
    @Column(nullable = false, length = TextSize.M)
    private String address;

    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

    @OneToOne(mappedBy = "location")
    private Vehicle vehicle;
}
