package com.waffle.data.entities.root;

import com.waffle.data.constants.types.admin.ModerationStatus;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.User;
import com.waffle.data.entities.behaviour.Persistable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Moderation entity.
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class ModerationEntity extends BasicEntity implements Persistable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModerationStatus status;

    @Column(length = TextSize.XXL)
    private String message;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    @PrePersist
    public void onPersist() {
        status = ModerationStatus.ON_REVIEW;
    }
}
