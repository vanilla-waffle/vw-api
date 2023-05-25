package com.waffle.data.models.other;

import com.waffle.data.entities.root.BasicEntity;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Criteria bundle.
 */
@Getter
@Accessors(fluent = true)
public final class CriteriaBundle {
    private final EntityManager em;
    private final CriteriaBuilder builder;
    private final CriteriaQuery<? extends BasicEntity> query;
    private final Root<? extends BasicEntity> root;

    private CriteriaBundle(final EntityManager em, final Class<? extends BasicEntity> clazz) {
        this.em = em;
        this.builder = em.getCriteriaBuilder();
        this.query = this.builder.createQuery(clazz);
        this.root = this.query.from(clazz);
    }

    /**
     * Static constructor.
     *
     * @param em {@link EntityManager}
     * @param clazz {@link Class}
     * @return {@link CriteriaBundle}
     */
    public static CriteriaBundle of(final EntityManager em, final Class<? extends BasicEntity> clazz) {
        return new CriteriaBundle(em, clazz);
    }
}


