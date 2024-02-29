package com.gadashov.hotelmanagementsystem.model.entity;

import com.gadashov.hotelmanagementsystem.model.enums.ReviewType;
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
    Long id;

    @Min(0)
    @Max(10)
    Integer rating;



    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @ToString.Exclude
    Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    Room room;

    @Enumerated(EnumType.STRING)
    ReviewType reviewType;

}
