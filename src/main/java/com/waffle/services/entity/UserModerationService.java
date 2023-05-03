package com.waffle.services.entity;

import com.waffle.data.entities.admin.UserModeration;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.PagingService;
import com.waffle.services.common.SpecificService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * Moderation service.
 */
public interface UserModerationService extends
        BasicService<UserModeration>,
        PagingService<UserModeration>,
        SpecificService<UserModeration> {

    /**
     * Find all.
     *
     * @param sort {@link Sort}
     * @param page {@link PageRequest}
     * @param by {@link Specification <UserModeratio>}
     * @return {@link Page <UserModeration>}
     */
    Page<UserModeration> findAll(Sort sort, PageRequest page, Specification<UserModeration> by);
}
