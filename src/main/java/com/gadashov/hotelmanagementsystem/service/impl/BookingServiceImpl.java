package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.BookingMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.BookingResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Booking;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.BookingException;
import com.gadashov.hotelmanagementsystem.repository.BookingRepository;
import com.gadashov.hotelmanagementsystem.service.BookingService;
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
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    @Override
    public void createBooking(CreateBookingRequest request) {
        Booking booking = bookingMapper.toBooking(request);
        bookingRepository.save(booking);
    }

    @Override
    public void updateBookingById(Long id, UpdateBookingRequest request) {
        Booking booking = findBookingById(id);
        Booking updatedBooking = bookingMapper.updateBooking(booking, request);
        bookingRepository.save(updatedBooking);
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        return bookingMapper.toBookingResponse(findBookingById(id));
    }

    @Override
    public List<BookingResponse> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(bookingMapper::toBookingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.delete(findBookingById(id));
    }

    @Override
    public Booking findBookingById(Long id){

        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingException(Exceptions.BOOKING_NOT_FOUND));
    }
}
