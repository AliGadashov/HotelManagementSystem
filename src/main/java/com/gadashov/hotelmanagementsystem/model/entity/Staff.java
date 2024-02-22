package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    String position;
    @Column(unique = true)
    String phone;
    @Email
    @Column(unique = true)
    String email;

    BigDecimal salary;

    LocalDate dateOfBirth;
    LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    Hotel hotel;

}
