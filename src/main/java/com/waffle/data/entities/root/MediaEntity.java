package com.waffle.data.entities.root;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Media base entity.
 */
@Getter
@Setter
@MappedSuperclass
public class MediaEntity extends BasicEntity {

    private String name;
    private String type;
    private double size;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(nullable = false)
    private byte[] data;
}
