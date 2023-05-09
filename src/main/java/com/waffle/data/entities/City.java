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
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class City extends BasicEntity {

    private String name;
}
