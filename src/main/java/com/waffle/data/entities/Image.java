package com.waffle.data.entities;

import com.waffle.data.entities.root.BasicEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Image entity.
 */
@Entity
@Table(name = "vw_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BasicEntity {

    private String name;
    private String url;
    private String type;
    private double size;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(nullable = false)
    private byte[] data;
}
