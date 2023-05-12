package com.waffle.services.composite.open.impl;

import com.waffle.data.entities.Image;
import com.waffle.data.entities.User;
import com.waffle.data.utils.mappers.ImageMapper;
import com.waffle.data.utils.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.services.entity.ImageService;
import com.waffle.services.utils.Sorts;
import com.waffle.services.composite.open.UserPublicService;
import com.waffle.services.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * User public service implementation.
 */
@Service
@AllArgsConstructor
public class UserPublicServiceImpl implements UserPublicService {
    private final UserService userService;
    private final ImageService imageService;
    private final UserMapper userMapper;
    private final ImageMapper imageMapper;

    @Override
    public List<UserPublicResponseDto> findAll(final String query) {
        final Sort sort = Sorts.of(query);
        final List<User> users = userService.findAll(sort);
        return userMapper.convertPublic(users);
    }

    @Override
    public Page<UserPublicResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<User> users = userService.findAll(sort, page);
        return users.map(userMapper::convertPublic);
    }

    @Override
    @Transactional
    public UserAllResponseDto save(final UserCreateDto payload, final MultipartFile file) {
        User user = userMapper.convert(payload);
        Image image;

        try {
            image = imageMapper.convert(file);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        image = imageService.upload(image);
        user.getProfile().setImage(image);
        user = userService.save(user);
        return userMapper.convertAll(user);
    }
}
