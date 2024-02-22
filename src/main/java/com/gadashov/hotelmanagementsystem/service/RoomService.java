package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Room;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface RoomService {

    void createRoom(CreateRoomRequest request);

    void updateRoomById(Long id, UpdateRoomRequest request);

    RoomResponse getRoomById(Long id);

    List<RoomResponse> getAllRoom();

    void deleteRoom(Long id);

    List<RoomResponse> getAllRoomByHotel(Long hotelId);

    List<RoomResponse> getAllRoomByRoomType(Long roomTypeId);
    Room findRoomById(Long id);
}
