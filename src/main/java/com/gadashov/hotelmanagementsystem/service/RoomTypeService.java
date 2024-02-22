package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomTypeResponse;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface RoomTypeService {

    void createRoomType(CreateRoomTypeRequest request);

    void updateRoomTypeById(Long id, UpdateRoomTypeRequest request);

    List<RoomTypeResponse> getAllRoomType();

    void deleteRoomType(Long id);

    RoomType findRoomTypeById(Long id);

    List<RoomTypeResponse> findRoomTypesByCapacity(Integer capacity);
}
