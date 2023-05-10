package com.waffle.data.entities.media;

import com.waffle.data.entities.Vehicle;
import com.waffle.data.entities.root.MediaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vehicle pictures entity.
 */
@Entity
@Table(name = "vw_vehicle_pictures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePictureMedia extends MediaEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
