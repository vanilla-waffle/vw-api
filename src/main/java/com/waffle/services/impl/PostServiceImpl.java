package com.waffle.services.impl;

import com.waffle.dto.request.PostCreateDto;
import com.waffle.dto.request.PostUpdateDto;
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
    public Post save(final PostCreateDto payload) {
        Post post = mapper.postCreateDtoToPost(payload);
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
    public Post update(final PostUpdateDto payload) {
        Post post = find(payload.getAuthorId());
        mapper.updatePostFromPostUpdateDto(payload, post);

        return repository.save(post);
    }

    @Override
    public void delete(final Long id) {

    }
}
