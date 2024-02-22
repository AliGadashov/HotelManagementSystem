package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    List<Hotel> getHotelByStars(int star);
}
