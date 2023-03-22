package com.waffle.services.impl;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.Post;
import com.waffle.repositories.PostRepository;
import com.waffle.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.repositories.specifications.PostSpecification.by;

/**
 * PostService implementation.
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    @Override
    public Post save(final Post payload) {
        return repository.save(payload);
    }

    @Override
    public Post find(final Long postId) {
        return repository.findById(postId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Post find(final SearchCriteria criteria) {
        return repository.findOne(by(criteria)).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public List<Post> findAll(final SearchCriteria criteria) {
        if (criteria.getKey() == null) {
            return repository.findAll();
        }

        return repository.findAll(by(criteria));
    }

    @Override
    public Post update(final Post payload) {
        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
