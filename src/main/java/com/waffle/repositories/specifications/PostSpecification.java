package com.waffle.repositories.specifications;

import com.waffle.data.entity.Post;
import org.springframework.data.jpa.domain.Specification;

/**
 * Specification class used to set search parameter.
 */
public final class PostSpecification {

    private PostSpecification() {

    }

    /**
     * Search post by author ID.
     *
     * @param id author id
     * @return search parameter
     */
    public Specification<Post> byAuthor(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("profile").get("id"),
                        id
                );
    }
}
