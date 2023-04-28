package com.waffle.repositories;

import com.waffle.data.entities.admin.UserModeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * User moderation repository.
 */
@Repository
public interface UserModerationRepository extends JpaRepository<UserModeration, Long>, JpaSpecificationExecutor<UserModeration> {
}
