package com.waffle.services.impl;

import com.waffle.mappers.PostMapper;
import com.waffle.data.entity.Post;
import com.waffle.repositories.PostRepository;
import com.waffle.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PostService implementation.
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public Post save(final Post payload) {
        return repository.save(payload);
    }

    @Override
    public Post find(final Long postId) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post update(final Post payload) {
        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {

    }
}
