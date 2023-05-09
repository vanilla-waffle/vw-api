package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Vehicle location entity.
 */
@Entity
@Table(name = "vw_locations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(nullable = false, length = TextSize.M)
    private String address;

    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

    @OneToOne(mappedBy = "location", fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
