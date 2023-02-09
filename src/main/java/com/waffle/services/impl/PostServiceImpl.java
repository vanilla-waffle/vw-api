package com.waffle.services.impl;

import com.waffle.dto.PostDto;
import com.waffle.mappers.PostMapper;
import com.waffle.models.entity.Post;
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
    public Post save(final PostDto.Request.Create payload) {
        Post post = mapper.createdToPost(payload);
        return repository.save(post);
    }

    @Override
    public Post find(final Long userId) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post update(final Post post) {
        return null;
    }

    @Override
    public void delete(final Long id) {

    }
}
