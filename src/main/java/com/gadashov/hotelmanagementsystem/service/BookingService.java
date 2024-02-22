package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.BookingResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Booking;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface BookingService {

    void createBooking(CreateBookingRequest request);
    void updateBookingById(Long id, UpdateBookingRequest request);

    BookingResponse getBookingById(Long id);

    List<BookingResponse> getAllBooking();

    void deleteBooking(Long id);

    Booking findBookingById(Long id);
}
