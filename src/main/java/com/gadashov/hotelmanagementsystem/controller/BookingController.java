package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.BookingResponse;
import com.gadashov.hotelmanagementsystem.service.BookingService;
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
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> createBooking(
            @RequestBody @Valid CreateBookingRequest request
    ){
        bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBookingById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateBookingRequest request
    ){
        bookingService.updateBookingById(id,request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(
            @PathVariable Long id
    ){
        BookingResponse bookingResponse = bookingService.getBookingById(id);
        return ResponseEntity.ok().body(bookingResponse);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBooking(){
        List<BookingResponse> bookingResponse = bookingService.getAllBooking();
        return ResponseEntity.ok().body(bookingResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(
            @PathVariable Long id
    ){
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
