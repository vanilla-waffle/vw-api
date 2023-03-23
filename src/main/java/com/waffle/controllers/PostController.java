package com.waffle.controllers;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.entity.Post;
import com.waffle.mappers.PostMapper;
import com.waffle.services.GeneralService;
import com.waffle.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * Post controller.
 */
@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
@Validated
@Slf4j
public class PostController {
    private final GeneralService generalService;
    private final PostService postService;
    private final PostMapper mapper;

    /**
     * Save new post.
     *
     * @param post request body
     * @return all response dto
     */
    @PostMapping
    public ResponseEntity<PostAllDto> save(@RequestBody @Valid @NotNull final PostCreateDto post) {
        log.info("[SAVE] Request to save post by user: {}", post.getAuthorId());
        final PostAllDto response = generalService.save(post);
        return status(OK).body(response);
    }

    /**
     * Find post by id.
     *
     * @param id post id
     * @return all response sto
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostAllDto> find(@PathVariable @Positive final Long id) {
        log.info("[FIND:id] Request to find post by id: {}", id);
        final Post post = postService.find(id);
        final PostAllDto response = mapper.fromPostToAllDto(post);
        return status(OK).body(response);
    }

    /**
     * Find user by pre-defined query.
     *
     * @param q query body
     * @return all response dto
     */
    @GetMapping("/search")
    public ResponseEntity<PostAllDto> find(@RequestParam @NotBlank final String q) {
        log.info("[FIND:search] Request to find post with query: {}", q);
        final SearchCriteria criteria = SearchCriteria.from(q);
        final Post post = postService.find(criteria);
        final PostAllDto response = mapper.fromPostToAllDto(post);
        return status(OK).body(response);
    }

    /**
     * Find users by pre-defined query.
     *
     * @param q query body
     * @return all response dto list
     */
    @GetMapping("/search-all")
    public ResponseEntity<List<PostAllDto>> findAll(@RequestParam @NotBlank final String q) {
        log.info("[FIND:search-all] Request to find posts with query: {}", q);
        final SearchCriteria criteria = SearchCriteria.from(q);
        final List<Post> posts = postService.findAll(criteria);
        final List<PostAllDto> response = mapper.fromPostToAllDto(posts);
        return status(OK).body(response);
    }

    /**
     * Delete existing user.
     *
     * @param id post id
     * @return success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Positive final Long id) {
        log.info("[DELETE:id] Request to delete user with id: {}", id);
        final Post post = postService.find(id);
        generalService.delete(id, post.getUser().getId());
        final String message = String.format("OK. Post {%s} was deleted.", id.toString());
        return status(OK).body(message);
    }

    /**
     * Update existing user.
     *
     * @param post post
     * @return all response dto
     */
    @PutMapping
    public ResponseEntity<PostAllDto> update(@RequestBody @Valid @NotNull final PostUpdateDto post) {
        log.info("[UPDATE] Request to update post");
        final PostAllDto response = generalService.update(post);
        return status(OK).body(response);
    }
}
