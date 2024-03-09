package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface GuestRepository extends JpaRepository<Guest,Long> {
    Guest getGuestByEmail(String email);

    Optional<Guest> findByEmail(String email);

}
