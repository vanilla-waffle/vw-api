package com.waffle.data.entities.media;

import com.waffle.data.entities.User;
import com.waffle.data.entities.root.MediaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * User picture entity.
 */
@Entity
@Table(name = "vw_user_pictures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPictureMedia extends MediaEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
