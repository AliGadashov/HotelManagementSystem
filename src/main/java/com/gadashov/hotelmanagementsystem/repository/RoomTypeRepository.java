package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {

    List<RoomType> getRoomTypeByCapacity(Integer capacity);

}
