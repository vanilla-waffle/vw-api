package com.waffle.data.repositories.specifications;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.entities.Booking;
import org.springframework.data.jpa.domain.Specification;

/**
 * Booking specification.
 */
public final class BookingSpecification {

    private BookingSpecification() {
    }

    /**
     * Search by user.
     *
     * @param id {@link Long}
     * @return {@link Specification<Booking>}
     */
    public static Specification<Booking> byUser(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("user").get("id"),
                        id
                );
    }

    /**
     * Search by owner.
     *
     * @param id {@link Long}
     * @return {@link Specification<Booking>}
     */
    public static Specification<Booking> byOwner(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("vehicle").join("user").get("id"),
                        id
                );
    }

    /**
     * Search by pending status.
     *
     * @param status {@link BookingStatus}
     * @return {@link Specification<Booking>}
     */
    public static Specification<Booking> byStatus(final BookingStatus status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("status"),
                        status
                );
    }

    /**
     * Search by vehicle.
     *
     * @param id {@link Long}
     * @return {@link Specification<Booking>}
     */
    public static Specification<Booking> byVehicle(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                    root.join("vehicle").get("id"),
                    id
                );
    }
}
