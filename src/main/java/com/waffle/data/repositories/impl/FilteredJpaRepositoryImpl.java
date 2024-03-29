package com.waffle.data.repositories.impl;

import com.waffle.data.entities.root.BasicEntity;
import com.waffle.data.repositories.FilteredJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

import static com.waffle.services.utils.Filters.toPredicates;
import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

/**
 * Vehicle filtered repository implementation.
 *
 * @param <T> entity extending {@link BasicEntity}
 * @param <ID> id
 */
public class FilteredJpaRepositoryImpl<T extends BasicEntity, ID> extends SimpleJpaRepository<T, ID> implements FilteredJpaRepository<T, ID> {
    private final EntityManager entityManager;

    /**
     * Constructor.
     *
     * @param entityInformation {@link JpaEntityInformation}
     * @param entityManager {@link EntityManager}
     */
    public FilteredJpaRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAll(final Map<String, String> params) {
        if (params.isEmpty()) {
            return findAll();
        }

        return getParametrizedQuery(params).getResultList();
    }

    @Override
    public Page<T> findAll(final Map<String, String> params, final Pageable pageable) {
        if (pageable.isUnpaged()) {
            return new PageImpl<>(findAll(params));
        }

        if (params.isEmpty()) {
            return findAll(pageable);
        }

        final TypedQuery<T> query = getParametrizedQuery(params, pageable);

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return PageableExecutionUtils.getPage(
                query.getResultList(),
                pageable,
                () -> getParametrizedCountQuery(params).getSingleResult()
        );
    }

    private TypedQuery<T> getParametrizedQuery(final Map<String, String> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = builder.createQuery(getDomainClass());
        final Root<T> root = query.from(getDomainClass());

        query
                .where(toPredicates(params, builder, root));

        return entityManager.createQuery(query);
    }

    private TypedQuery<T> getParametrizedQuery(final Map<String, String> params, final Pageable pageable) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = builder.createQuery(getDomainClass());
        final Root<T> root = query.from(getDomainClass());

        query
                .where(toPredicates(params, builder, root))
                .orderBy(toOrders(pageable.getSort(), root, builder));

        return entityManager.createQuery(query);
    }

    private TypedQuery<Long> getParametrizedCountQuery(final Map<String, String> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        final Root<T> root = query.from(getDomainClass());

        query
                .select(builder.count(root))
                .where(toPredicates(params, builder, root));

        return entityManager.createQuery(query);
    }
}
