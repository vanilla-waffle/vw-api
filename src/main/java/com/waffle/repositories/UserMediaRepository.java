package com.waffle.repositories;

import com.waffle.data.entities.media.UserPictureMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User media repository.
 */
@Repository
public interface UserMediaRepository extends JpaRepository<UserPictureMedia, Long> {
}
