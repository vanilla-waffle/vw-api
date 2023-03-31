package com.waffle.services.entity.impl;

import com.waffle.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * UserService implementation.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository repository;
}
