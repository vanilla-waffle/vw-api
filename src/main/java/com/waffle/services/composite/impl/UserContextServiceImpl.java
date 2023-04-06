package com.waffle.services.composite.impl;

import com.waffle.data.constants.exceptions.UserNotFoundException;
import com.waffle.data.dto.other.UserContext;
import com.waffle.data.entities.User;
import com.waffle.data.mappers.UserMapper;
import com.waffle.services.composite.UserContextService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Custom user details service.
 */
@Service
@RequiredArgsConstructor
public class UserContextServiceImpl implements UserContextService {
    private final UserService service;
    private final UserMapper mapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = service.find(username);
        return mapper.convert(user);
    }

    @Override
    @Transactional
    public UserContext load(final String username) throws UsernameNotFoundException {
        try {
            final User user = service.find(username);
            return mapper.convert(user);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
