package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String status;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomType_id")
    @ToString.Exclude
    RoomType roomType;
}
