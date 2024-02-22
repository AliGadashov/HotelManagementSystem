package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.RoomMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.entity.Room;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.RoomException;
import com.gadashov.hotelmanagementsystem.repository.RoomRepository;
import com.gadashov.hotelmanagementsystem.service.HotelService;
import com.gadashov.hotelmanagementsystem.service.RoomService;
import com.gadashov.hotelmanagementsystem.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;
    @Override
    public void createRoom(CreateRoomRequest request) {
        Room room = roomMapper.toRoom(request);
        roomRepository.save(room);
    }

    @Override
    public void updateRoomById(Long id, UpdateRoomRequest request) {
        Room room = findRoomById(id);
        Room updatedRoom = roomMapper.updateRoom(room, request);
        roomRepository.save(updatedRoom);
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        return roomMapper.toRoomResponse(findRoomById(id));
    }

    @Override
    public List<RoomResponse> getAllRoom() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(roomMapper::toRoomResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.delete(findRoomById(id));
    }

    @Override
    public List<RoomResponse> getAllRoomByHotel(Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Room> rooms = hotel.getRooms();
        return rooms.stream()
                .map(roomMapper::toRoomResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> getAllRoomByRoomType(Long roomTypeId) {
        RoomType roomType = roomTypeService.findRoomTypeById(roomTypeId);
        List<Room> rooms = roomType.getRooms();
        return rooms.stream()
                .map(roomMapper::toRoomResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Room findRoomById(Long id){

        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomException(Exceptions.ROOM_NOT_FOUND));
    }
}
