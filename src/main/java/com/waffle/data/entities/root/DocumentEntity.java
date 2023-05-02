package com.waffle.data.entities.root;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * Common class for all documents.
 */
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class DocumentEntity extends BasicEntity {

    private boolean approved;
}
