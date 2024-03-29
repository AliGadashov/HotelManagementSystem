package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
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
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    String address;
    @Column(unique = true)
    String phone;
    @Email
    @Column(unique = true)
    String email;

    String password;

    @Builder.Default
    Boolean isEnable = false;

    LocalDate dateOfBirth;

    @OneToMany(mappedBy = "guest")
    @ToString.Exclude
    List<Booking> booking;

    @OneToMany(mappedBy = "guest")
    @ToString.Exclude
    List<GuestReview> guestReviews;

    @ManyToMany
    @JoinTable(
            name = "guest_hotel",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    @ToString.Exclude
    List<Hotel> hotels;

}
