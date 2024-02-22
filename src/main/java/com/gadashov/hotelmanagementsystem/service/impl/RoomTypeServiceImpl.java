package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.RoomTypeMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomTypeResponse;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.RoomTypeException;
import com.gadashov.hotelmanagementsystem.repository.RoomTypeRepository;
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
public class RoomTypeServiceImpl implements RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;
    private final RoomTypeMapper roomTypeMapper;
    @Override
    public void createRoomType(CreateRoomTypeRequest request) {
        RoomType roomType = roomTypeMapper.toRoomType(request);
        roomTypeRepository.save(roomType);
    }

    @Override
    public void updateRoomTypeById(Long id, UpdateRoomTypeRequest request) {
        RoomType roomType = findRoomTypeById(id);
        RoomType updatedRoomType = roomTypeMapper.updateRoomType(roomType, request);
        roomTypeRepository.save(updatedRoomType);
    }

    @Override
    public void deleteRoomType(Long id) {
        roomTypeRepository.delete(findRoomTypeById(id));
    }

    @Override
    public List<RoomTypeResponse> getAllRoomType() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        return roomTypes.stream()
                .map(roomTypeMapper::toRoomTypeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomType findRoomTypeById(Long id){

        return roomTypeRepository.findById(id)
                .orElseThrow(() -> new RoomTypeException(Exceptions.ROOM_TYPE_NOT_FOUND));
    }

    @Override
    public List<RoomTypeResponse> findRoomTypesByCapacity(Integer capacity) {
        List<RoomType> roomTypeByCapacity = roomTypeRepository.getRoomTypeByCapacity(capacity);
        return roomTypeByCapacity.stream()
                .map(roomTypeMapper::toRoomTypeResponse)
                .collect(Collectors.toList());
    }
}
