package com.waffle.data.entities;

import com.waffle.data.entities.behaviour.Persistable;
import com.waffle.data.entities.root.BasicEntity;
import com.waffle.services.utils.Urls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

/**
 * Image entity.
 */
@Entity
@Table(name = "vw_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BasicEntity implements Persistable {

    @Column(unique = true)
    private String uuid;

    private String url;
    private String type;
    private double size;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(nullable = false)
    private byte[] data;

    @Override
    @PrePersist
    public void onPersist() {
        uuid = UUID.randomUUID().toString();
        url = Urls.host() + ":" + Urls.port() + "/api/public/media/" + uuid;
    }
}
