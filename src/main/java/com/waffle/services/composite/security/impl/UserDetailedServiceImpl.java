package com.waffle.services.composite.security.impl;

import com.waffle.data.entities.User;
import com.waffle.data.utils.mappers.UserMapper;
import com.waffle.data.models.other.UserContext;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailedServiceImpl implements UserDetailsService {
    private final UserService userService;
    private final UserMapper mapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        try {
            final User user = userService.find(username);
            return toDetails(user);
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    private UserContext toDetails(final User user) {
        return new UserContext(
                user.getProfile().getUsername(),
                user.getProfile().getPassword(),
                mapper.convertAll(user),
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.getRole().toString()))
                        .collect(Collectors.toList())
        );
    }
}
