package com.waffle.services.composite.impl;

import com.waffle.data.dto.response.user.root.UserAllResponseDto;
import com.waffle.data.entities.User;
import com.waffle.data.entities.embedded.user.Profile;
import com.waffle.data.mappers.UserMapper;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom user details service.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService service;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = service.find(username);
        return (UserDetails) mapper.convertAll(user);
    }
}
