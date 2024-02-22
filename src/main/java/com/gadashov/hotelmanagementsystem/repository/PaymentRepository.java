package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByBookingId(Long bookingId);
}
