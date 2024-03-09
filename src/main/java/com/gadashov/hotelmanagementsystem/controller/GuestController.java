package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.ResetPasswordRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.service.GuestService;
import jakarta.validation.Valid;
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

    @PostMapping("/registration")
    public ResponseEntity<Void> registration(
            @RequestBody @Valid CreateGuestRequest request
    ){
        guestService.registration(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/confirmation")
    public ResponseEntity<Void> confirmation(
            @RequestParam String token
    ){
        guestService.confirmation(token);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/renew-password/{username}",
    method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> renewPassword(
            @PathVariable String username
    ){
        guestService.renewPassword(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestParam Integer otp,
            @RequestParam String username,
            @RequestBody ResetPasswordRequest request
    ){
        guestService.resetPassword(username,otp, request);
        return ResponseEntity.ok().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGuestById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateGuestRequest request
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
