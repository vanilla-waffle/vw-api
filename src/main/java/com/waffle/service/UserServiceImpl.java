package com.waffle.service;


import com.waffle.entity.User;
import com.waffle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User find(final Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User update(final User user) {
        return null;
    }

    @Override
    public void delete(final Long id) {

    }
}
