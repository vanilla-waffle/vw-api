package com.waffle.mapper;


import com.waffle.dto.request.UserCreateDto;
import com.waffle.dto.request.UserUpdateDto;
import com.waffle.mappers.UserMapper;
import com.waffle.models.constants.types.City;
import com.waffle.models.constants.types.Status;
import com.waffle.models.embedded.Profile;
import com.waffle.models.entity.User;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {
    private static final EasyRandom generator = new EasyRandom();

    @Test
    public void userCreateDtoToUserMappingTest() {
        UserCreateDto source = generator.nextObject(UserCreateDto.class);

        User user = UserMapper.INSTANCE.userCreateDtoToUser(source);

        assertThat(user.getProfile().getEmail()).isEqualTo(source.getEmail());
        assertThat(user.getProfile().getPassword()).isEqualTo(source.getPassword());
        assertThat(user.getProfile().getFirstName()).isEqualTo(source.getFirstName());
        assertThat(user.getProfile().getLastName()).isEqualTo(source.getLastName());
        assertThat(user.getProfile().getCity()).isEqualTo(source.getCity());
    }

    @Test
    public void updateUserFromUserCreateDtoMappingTest() {
        UserUpdateDto source = generator.nextObject(UserUpdateDto.class);

        User user = createUser(); //generator.nextObject(User.class);

        UserMapper.INSTANCE.updateUserFromUserUpdateDto(source, user);

        if (source.getProfile().getEmail() != null)
            assertThat(user.getProfile().getEmail()).isEqualTo(source.getProfile().getEmail());
        if (source.getProfile().getPassword() != null)
            assertThat(user.getProfile().getPassword()).isEqualTo(source.getProfile().getPassword());
        if (source.getProfile().getFirstName() != null)
            assertThat(user.getProfile().getFirstName()).isEqualTo(source.getProfile().getFirstName());
        if (source.getProfile().getLastName() != null)
            assertThat(user.getProfile().getLastName()).isEqualTo(source.getProfile().getLastName());
        if (source.getProfile().getCity() != null)
            assertThat(user.getProfile().getCity()).isEqualTo(source.getProfile().getCity());
    }

    private UserCreateDto createUserCreateDto() {
        UserCreateDto userCreateDto = new UserCreateDto();

//        userCreateDto.setEmail("zhoma@gmail.com");
//        userCreateDto.setPassword("54321");
//        userCreateDto.setFirstName("zhoma");
//        userCreateDto.setLastName("talgatuly");
        userCreateDto.setCity(City.SHYMKENT);

        return userCreateDto;
    }

    private User createUser() {
        User user = new User();

        Profile profile = new Profile();
        profile.setEmail("arman@gmail.com");
        profile.setPassword("12345");
        profile.setFirstName("arman");
        profile.setLastName("amirgaliyev");
        profile.setCity(City.ASTANA);

        user.setId(1L);
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(Status.ACTIVE);
        user.setProfile(profile);
        user.setPosts(Collections.emptyList());

        return user;
    }
}
