package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.common.TextSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Review entity.
 */
@Entity
@Table(name = "vw_reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;

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