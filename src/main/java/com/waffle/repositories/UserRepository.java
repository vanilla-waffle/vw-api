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

    boolean existsByProfileEmail(String email);

    Optional<User> findByProfileEmail(String email);
}
