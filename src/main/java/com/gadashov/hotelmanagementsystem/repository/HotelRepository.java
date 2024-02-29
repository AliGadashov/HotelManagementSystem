package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    List<Hotel> getHotelByStars(int star);
}
