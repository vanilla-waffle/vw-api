package com.waffle.data.entities;

import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * City entity.
 */
@Entity
@Table(name = "vw_cities")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City extends BasicEntity {

    private String name;
}
