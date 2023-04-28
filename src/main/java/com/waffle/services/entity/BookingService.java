package com.waffle.services.entity;

import com.waffle.data.entities.Booking;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.PagingService;
import com.waffle.services.common.SortingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * Booking service.
 */
public interface BookingService extends
        BasicService<Booking>,
        SortingService<Booking>,
        PagingService<Booking> {

    /**
     * Find all.
     *
     * @param sort {@link Sort}
     * @param page {@link PageRequest}
     * @param by {@link Specification<Booking>}
     * @return {@link Page<Booking>}
     */
    Page<Booking> findAll(Sort sort, PageRequest page, Specification<Booking> by);
}
