package com.waffle.services.composite;

import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * User public service.
 */
public interface UserPublicService {

    /**
     * Find all.
     *
     * @param sort {@link String}
     * @return {@link UserPublicResponseDto}
     */
    List<UserPublicResponseDto> findAll(String sort);

    /**
     * Find all.
     *
     * @param sort {@link String}
     * @param page {@link PageRequest}
     * @return {@link Page<UserPublicResponseDto>}
     */
    Page<UserPublicResponseDto> findAll(String sort, PageRequest page);

    /**
     * Save new user.
     *
     * @param payload {@link UserCreateDto}
     * @param file
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto save(UserCreateDto payload, final MultipartFile file);
}
