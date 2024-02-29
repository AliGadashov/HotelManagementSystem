package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.StaffResponse;
import com.gadashov.hotelmanagementsystem.service.StaffService;
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
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<Void> createStaff(
            @RequestBody @Valid CreateStaffRequest request
    ){
        staffService.createStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStaffById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateStaffRequest request
    ){
        staffService.updateStaffById(id,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(
            @PathVariable Long id
    ){
        staffService.deleteStaff(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffResponse> getStaffById(
            @PathVariable Long id
    ){
        StaffResponse staffResponse = staffService.getStaffById(id);
        return ResponseEntity.ok().body(staffResponse);
    }

    @GetMapping
    public ResponseEntity<List<StaffResponse>> getAllStaff(){
        List<StaffResponse> staffResponse = staffService.getAllStaff();
        return ResponseEntity.ok().body(staffResponse);
    }

    @GetMapping("/{hotelId}/hotel")
    public ResponseEntity<List<StaffResponse>> getAllStaffByHotel(
            @PathVariable Long hotelId
    ){
        List<StaffResponse> staffResponses = staffService.getAllStaffByHotel(hotelId);
        return ResponseEntity.ok().body(staffResponses);
    }


}
