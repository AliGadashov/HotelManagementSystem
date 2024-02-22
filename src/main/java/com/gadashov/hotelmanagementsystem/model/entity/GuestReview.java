package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/22/2024
 * Time: 5:43 PM
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuestReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Max(10)
    private Integer rating;

    // Other fields like comment, guest details, etc.

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    private Hotel hotel;

}
