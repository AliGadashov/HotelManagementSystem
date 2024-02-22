package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

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
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    Integer capacity;

    BigDecimal pricePerNight;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Room> rooms;
}
