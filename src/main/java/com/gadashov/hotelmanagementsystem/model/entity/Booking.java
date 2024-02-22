package com.gadashov.hotelmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    BigDecimal totalPrice;

    @CreationTimestamp
    LocalDateTime checkInTime;
    @UpdateTimestamp
    LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @ToString.Exclude
    Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @ToString.Exclude
    Guest guest;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    List<Payment> payments;
}
