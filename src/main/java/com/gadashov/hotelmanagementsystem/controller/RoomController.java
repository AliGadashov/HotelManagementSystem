package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomResponse;
import com.gadashov.hotelmanagementsystem.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@RestController
@RequestMapping("api/v1/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<Void> createRoom(
            @RequestBody CreateRoomRequest request
    ){
        roomService.createRoom(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomById(
            @PathVariable Long id,
            @RequestBody UpdateRoomRequest request
    ){
        roomService.updateRoomById(id,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long id
    ){
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(
            @PathVariable Long id
    ){
        RoomResponse roomResponse = roomService.getRoomById(id);
        return ResponseEntity.ok().body(roomResponse);
    }

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRoom(){
        List<RoomResponse> roomResponse = roomService.getAllRoom();
        return ResponseEntity.ok().body(roomResponse);
    }

    @GetMapping("/RoomByHotel")
    public ResponseEntity<List<RoomResponse>> getAllRoomByHotel(
            @RequestParam Long hotelId
    ){
        List<RoomResponse> roomResponse = roomService.getAllRoomByHotel(hotelId);
        return ResponseEntity.ok().body(roomResponse);
    }

    @GetMapping("/{roomTypeId}/roomType")
    public ResponseEntity<List<RoomResponse>> getAllRoomByRoomType(
            @PathVariable Long roomTypeId

    ){
        List<RoomResponse> roomResponse = roomService.getAllRoomByRoomType(roomTypeId);
        return ResponseEntity.ok().body(roomResponse);
    }
}
