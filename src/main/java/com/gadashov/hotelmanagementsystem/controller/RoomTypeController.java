package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomTypeResponse;
import com.gadashov.hotelmanagementsystem.service.RoomTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/room-type")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @PostMapping
    public ResponseEntity<Void> createRoomType(
            @RequestBody @Valid CreateRoomTypeRequest request
    ){
        roomTypeService.createRoomType(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomTypeById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateRoomTypeRequest request
    ){
        roomTypeService.updateRoomTypeById(id,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomType(
            @PathVariable Long id
    ){
        roomTypeService.deleteRoomType(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<RoomTypeResponse>> getAllRoomType(){
        List<RoomTypeResponse> roomTypeResponse = roomTypeService.getAllRoomType();
        return ResponseEntity.ok().body(roomTypeResponse);
    }

    @GetMapping("/capacity/{capacity}")
    public ResponseEntity<List<RoomTypeResponse>> findRoomTypesByCapacity(
            @PathVariable Integer capacity
    ){
        List<RoomTypeResponse> roomTypeResponse = roomTypeService.findRoomTypesByCapacity(capacity);
        return ResponseEntity.ok().body(roomTypeResponse);
    }


}
