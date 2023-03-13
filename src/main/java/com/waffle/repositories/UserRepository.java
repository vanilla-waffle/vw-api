package com.waffle.repositories;

import com.waffle.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User repository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Check if user with provided email exists.
     *
     * @param email user email
     * @return check result
     */
    boolean existsByProfileEmail(String email);

    /**
     * Find user by profile email.
     *
     * @param email user email
     * @return user
     */
    Optional<User> findByProfileEmail(String email);
}
