package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.HotelResponse;
import com.gadashov.hotelmanagementsystem.service.HotelService;
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
@RequestMapping("api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Void> createHotel(
            @RequestBody @Valid CreateHotelRequest request
    ){
        hotelService.createHotel(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateHotelById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateHotelRequest request
    ){
        hotelService.updateHotelById(id,request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotelById(
            @PathVariable Long id
    ){
        HotelResponse hotelResponse = hotelService.getHotelById(id);
        return ResponseEntity.ok().body(hotelResponse);
    }

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotel(){
        List<HotelResponse> hotelResponse = hotelService.getAllHotel();
        return ResponseEntity.ok().body(hotelResponse);
    }


    @GetMapping("/hotelByStar")
    public ResponseEntity<List<HotelResponse>> getAllHotelByStar(
            @RequestParam int star
    ){
        List<HotelResponse> hotelResponse = hotelService.getAllHotelByStar(star);
        return ResponseEntity.ok().body(hotelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(
            @PathVariable Long id
    ){
        hotelService.deleteHotel(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
