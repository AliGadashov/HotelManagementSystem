package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.service.GuestService;
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
@RequiredArgsConstructor
@RequestMapping("api/v1/guest")
public class GuestController {

    private final GuestService guestService;

    @PostMapping
    public ResponseEntity<Void> createGuest(
            @RequestBody CreateGuestRequest request
    ){
        guestService.createGuest(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGuestById(
            @PathVariable Long id,
            @RequestBody UpdateGuestRequest request
    ){
        guestService.updateGuestById(id,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(
            @PathVariable Long id
    ){
        guestService.deleteGuest(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestResponse> getGuestById(
            @PathVariable Long id
    ){
        GuestResponse guestResponse = guestService.getGuestById(id);
        return ResponseEntity.ok().body(guestResponse);
    }

    @GetMapping
    public ResponseEntity<List<GuestResponse>> getAllGuest(){
        List<GuestResponse> guestResponse = guestService.getAllGuest();
        return ResponseEntity.ok().body(guestResponse);
    }


    @GetMapping("/{hotelId}/GuestByHotel")
    public ResponseEntity<List<GuestResponse>> getAllGuestByHotel(
            @PathVariable Long hotelId
    ){
        List<GuestResponse> guestResponse = guestService.getAllGuestByHotel(hotelId);
        return ResponseEntity.ok().body(guestResponse);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<GuestResponse> getAllGuestByEmail(
            @PathVariable String email
    ){
        GuestResponse guestResponse = guestService.getAllGuestByEmail(email);
        return ResponseEntity.ok().body(guestResponse);
    }



}
