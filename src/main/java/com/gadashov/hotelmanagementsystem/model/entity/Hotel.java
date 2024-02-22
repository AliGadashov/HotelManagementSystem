package com.gadashov.hotelmanagementsystem.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String address;
    String phone;
    @Email
    @Column(unique = true)
    String email;

    @Min(0)
    @Max(5)
    Integer stars;


    Double averageRating;

    @CreationTimestamp
    LocalDateTime checkInTime;
    @UpdateTimestamp
    LocalDateTime checkOutTime;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Staff> staffs;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Room> rooms;


    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Guest> guests;


    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    List<GuestReview> guestReviews;


}
