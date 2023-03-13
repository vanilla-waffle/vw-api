package com.waffle.mapper;

import com.waffle.dto.request.PostCreateDto;
import com.waffle.dto.request.PostUpdateDto;
import com.waffle.mappers.PostMapper;
import com.waffle.models.entity.Post;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostMapperTest {
    private static final EasyRandom generator = new EasyRandom();

    @Test
    public void postCreateDtoToPostMappingTest() {
        PostCreateDto source = generator.nextObject(PostCreateDto.class);

        Post post = PostMapper.INSTANCE.postCreateDtoToPost(source);

        assertThat(post.getTitle()).isEqualTo(source.getTitle());
        assertThat(post.getModel()).isEqualTo(source.getModel());
        assertThat(post.getDescription()).isEqualTo(source.getDescription());
        assertThat(post.getManufacturer()).isEqualTo(source.getManufacturer());
        assertThat(post.getReleaseYear()).isEqualTo(source.getReleaseYear());
        assertThat(post.getPaymentPlan().getPrice()).isEqualTo(source.getPaymentPlan().getPrice());
        assertThat(post.getPaymentPlan().getPayment()).isEqualTo(source.getPaymentPlan().getPayment());
        assertThat(post.getFeatures()).isEqualTo(source.getFeatures());
        assertThat(post.getSpecification().getDoors()).isEqualTo(source.getSpecification().getDoors());
        assertThat(post.getSpecification().getSeats()).isEqualTo(source.getSpecification().getSeats());
        assertThat(post.getSpecification().getBody()).isEqualTo(source.getSpecification().getBody());
        assertThat(post.getSpecification().getColor()).isEqualTo(source.getSpecification().getColor());
        assertThat(post.getSpecification().getDrive()).isEqualTo(source.getSpecification().getDrive());
        assertThat(post.getSpecification().getEngineVolume()).isEqualTo(source.getSpecification().getEngineVolume());
        assertThat(post.getSpecification().getTransmission()).isEqualTo(source.getSpecification().getTransmission());
    }

    @Test
    public void updatePostFromPostUpdateDtoMappingTest() {
        PostUpdateDto source = generator.nextObject(PostUpdateDto.class);

        Post post = generator.nextObject(Post.class);

        PostMapper.INSTANCE.updatePostFromPostUpdateDto(source, post);

        assertThat(post.getTitle()).isEqualTo(source.getTitle());
        assertThat(post.getModel()).isEqualTo(source.getModel());
        assertThat(post.getDescription()).isEqualTo(source.getDescription());
        assertThat(post.getManufacturer()).isEqualTo(source.getManufacturer());
        assertThat(post.getReleaseYear()).isEqualTo(source.getReleaseYear());
        assertThat(post.getPaymentPlan().getPrice()).isEqualTo(source.getPaymentPlan().getPrice());
        assertThat(post.getPaymentPlan().getPayment()).isEqualTo(source.getPaymentPlan().getPayment());
        assertThat(post.getFeatures()).isEqualTo(source.getFeatures());
        assertThat(post.getSpecification().getDoors()).isEqualTo(source.getSpecification().getDoors());
        assertThat(post.getSpecification().getSeats()).isEqualTo(source.getSpecification().getSeats());
        assertThat(post.getSpecification().getBody()).isEqualTo(source.getSpecification().getBody());
        assertThat(post.getSpecification().getColor()).isEqualTo(source.getSpecification().getColor());
        assertThat(post.getSpecification().getDrive()).isEqualTo(source.getSpecification().getDrive());
        assertThat(post.getSpecification().getEngineVolume()).isEqualTo(source.getSpecification().getEngineVolume());
        assertThat(post.getSpecification().getTransmission()).isEqualTo(source.getSpecification().getTransmission());
    }
}
