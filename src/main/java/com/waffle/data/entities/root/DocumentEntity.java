package com.waffle.data.entities.root;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

/**
 * Common class for all documents.
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class DocumentEntity extends BasicEntity {

    private boolean approved;
}
