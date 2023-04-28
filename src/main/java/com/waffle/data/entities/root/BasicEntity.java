package com.waffle.data.entities.root;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Base entity.
 */
@Data
@MappedSuperclass
public class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @CreationTimestamp
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime updatedAt;
}
