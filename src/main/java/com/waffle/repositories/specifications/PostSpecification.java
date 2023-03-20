package com.waffle.repositories.specifications;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.Post;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import static com.waffle.data.constants.types.other.Operation.EQUAL;

/**
 * Specification class used to set search parameter.
 */
public final class PostSpecification {

    private PostSpecification() {

    }

    /**
     * Search by pre-defined criteria of key, operation and value.
     *
     * @param criteria search criteria
     * @return search parameter
     */
    public static Specification<Post> by(final SearchCriteria criteria) {
        return (root, query, builder) -> {
            Path<Object> path = getPath(root, criteria);

            switch (criteria.getOperation()) {
                case EQUAL:
                    return builder.equal(
                            path, criteria.getValue()
                    );
                default:
                    return null;
            }
        };
    }

    private static Path<Object> getPath(final Root<Post> root, final SearchCriteria criteria) {
        Path<Object> path;

        if (criteria.getKey().contains(".")) {
            String[] split = criteria.getKey().split("\\.");
            int keyPosition = 0;
            path = root.get(split[keyPosition]);

            for (String criteriaKeys : split) {
                if (keyPosition > 0) {
                    path = path.get(criteriaKeys);
                }
                keyPosition++;
            }
        } else {
            path = root.get(criteria.getKey());
        }

        return path;
    }

    /**
     * Search post by author ID.
     *
     * @param id author id
     * @return search parameter
     */
    public static Specification<Post> byAuthor(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("profile").get("id"),
                        id
                );
    }

    /**
     * Search post by title.
     *
     * @param title post title
     * @return search parameter
     */
    public static Specification<Post> byTitle(final String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("title"),
                        title
                );
    }
}
