package com.waffle.data.repositories;

import com.waffle.data.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        FilteredJpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {
}
