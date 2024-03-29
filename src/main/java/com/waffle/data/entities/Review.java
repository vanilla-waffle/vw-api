package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.entities.root.BasicEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vw_reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Review extends BasicEntity {

    @Column(nullable = false)
    private Integer rating;
    @Column(nullable = false, length = TextSize.XXL)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Vehicle vehicle;
}
