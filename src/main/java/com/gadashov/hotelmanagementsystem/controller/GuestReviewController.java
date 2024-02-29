package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestReviewResponse;
import com.gadashov.hotelmanagementsystem.service.GuestReviewService;
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
 * Date: 2/26/2024
 * Time: 10:03 AM
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/guestReview")
public class GuestReviewController {
private final GuestReviewService guestReviewService;

    @PostMapping
    public ResponseEntity<Void> createGuestReview(
            @RequestBody @Valid CreateGuestReviewRequest request
    ){
        guestReviewService.createGuestReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{guestId}")
    public ResponseEntity<Void> updateGuestReviewByUserId(
            @PathVariable Long guestId,
            @RequestBody @Valid UpdateGuestReviewRequest request
    ){
        guestReviewService.updateGuestReviewByUserId(guestId,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuestReview(
            @PathVariable Long id
    ){
        guestReviewService.deleteGuestReview(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{guestId}")
    public ResponseEntity<List<GuestReviewResponse>> getGuestReviewsByGuestId(
            @PathVariable Long guestId
    ){
        List<GuestReviewResponse> guestReviewResponse = guestReviewService.getGuestReviewByUserId(guestId);
        return ResponseEntity.ok().body(guestReviewResponse);
    }


    @GetMapping("/{hotelId}/GuestReviewsByHotel")
    public ResponseEntity<List<GuestReviewResponse>> getAllGuestReviewsByHotel(
            @PathVariable Long hotelId
    ){
        List<GuestReviewResponse> guestReviewResponse = guestReviewService.getAllGuestReviewsByHotel(hotelId);
        return ResponseEntity.ok().body(guestReviewResponse);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<GuestReviewResponse>> getAllGuestReviewByRoom(
            @PathVariable Long roomId
    ){
        List<GuestReviewResponse> guestReviewResponse = guestReviewService.getAllGuestReviewByRoom(roomId);
        return ResponseEntity.ok().body(guestReviewResponse);
    }

}
