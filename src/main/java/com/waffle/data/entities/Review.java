package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.common.TextSize;
import lombok.*;

import javax.persistence.*;

/**
 * Review entity.
 */
@Entity
@Table(name = "vw_reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity {

    @Column(nullable = false)
    private Integer rating;
    @Column(nullable = false, length = TextSize.XL)
    private String text;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference(value = "user-reviews")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference(value = "vehicle-reviews")
    private Vehicle vehicle;
}
